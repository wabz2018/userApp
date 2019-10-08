"use strict";

// Class definition
var KTWizard1 = function () {
    // Base elements
    var wizardEl;
    var formEl;
    var validator;
    var wizard;

    // Private functions
    var initWizard = function () {
        // Initialize form wizard
        wizard = new KTWizard('kt_wizard_v1', {
            startStep: 1
        });

        // Validation before going to next page
        wizard.on('beforeNext', function (wizardObj) {
            if (validator.form() !== true) {
                wizardObj.stop();  // don't go to the next step
            }
        });

        wizard.on('beforePrev', function (wizardObj) {
            if (validator.form() !== true) {
                wizardObj.stop();  // don't go to the next step
            }
        });

        // Change event
        wizard.on('change', function (wizard) {
            setTimeout(function () {
                KTUtil.scrollTop();
            }, 500);
        });
    }

    var initValidation = function () {
        validator = formEl.validate({
            // Validate only visible fields
            ignore: ":hidden",

            // Validation rules
            rules: {
                //= Step 1
                address1: {
                    required: true
                },
                postcode: {
                    required: true
                },
                city: {
                    required: true
                },
                state: {
                    required: true
                },
                country: {
                    required: true
                },

                //= Step 2
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },

            },

            // Display error  
            invalidHandler: function (event, validator) {
                KTUtil.scrollTop();

                swal.fire({
                    "title": "",
                    "text": "There are some errors in your submission. Please correct them.",
                    "type": "error",
                    "confirmButtonClass": "btn btn-secondary"
                });
            },

            // Submit valid form
            submitHandler: function (form) {

            }
        });
    }

    var initSubmit = function () {
        var btn = formEl.find('[data-ktwizard-type="action-submit"]');

        btn.on('click', function (e) {
            e.preventDefault();

            if (validator.form()) {
                // See: src\js\framework\base\app.js
                KTApp.progress(btn);
                //KTApp.block(formEl);

                // See: http://malsup.com/jquery/form/#ajaxSubmit
                formEl.ajaxSubmit({
                    success: function () {
                        KTApp.unprogress(btn);
                        var eml=sessionStorage.getItem("loggedInMail");
                        var values = {}
                        values["email"] =eml;
                        values["firstName"] = $("#firstName").val();
                        values["lastName"] = $("#lastName").val();
                        values["country"] = $("#country").val();
                        values["state"] = $("#state").val();
                        values["city"] = $("#city").val();
                        values["postalCode"] = $("#postcode").val();
                        values["address"] = $("#address").val();
                        values["phone"] = $("#phone").val();
                        var xhr = new XMLHttpRequest();
                        var url = "http://174.138.183.56:8000/user/profile/";
                        xhr.open("POST", url, true);
                        xhr.setRequestHeader("Content-type", "application/json");
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                var response = JSON.parse(xhr.responseText);
                                console.log(response);
                                var message = response['message'];
                                var title = response['title'];
                                var verify = response['verify'];
                                if (title === ("loggedOut")) {
                                    window.location.href = "http://174.138.183.56/job/";
                                    setTimeout(function () {
                                        btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                        showErrorMsg(form, 'danger', message);
                                    }, 2000);
                                } else {
                                    if (title === ("successful")) {
                                        setTimeout(function () {
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'success', message);
                                        }, 2000);
                                        swal.fire({
                                            "title": "",
                                            "text": "The application has been successfully submitted!",
                                            "type": "success",
                                            "confirmButtonClass": "btn btn-secondary"
                                        });
                                    } else {
                                        setTimeout(function () {
                                            btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                            showErrorMsg(form, 'danger', message);
                                        }, 2000);
                                    }
                                }
                            } else {
                                setTimeout(function () {
                                    btn.removeClass('kt-spinner kt-spinner--right kt-spinner--sm kt-spinner--light').attr('disabled', false);
                                    showErrorMsg(form, 'danger', 'Server Error.');
                                }, 2000);
                            }
                        };
                        var data = JSON.stringify(values);
                        xhr.send(data);


                    }
                });
            }
        });
    }

    return {
        // public functions
        init: function () {
            wizardEl = KTUtil.get('kt_wizard_v1');
            formEl = $('#kt_form');

            initWizard();
            initValidation();
            initSubmit();
        }
    };
}();

jQuery(document).ready(function () {
    KTWizard1.init();
});