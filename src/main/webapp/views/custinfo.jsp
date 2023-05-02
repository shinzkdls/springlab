<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let custinfo_form = {
        init: function () {
            $("#custinfo_btn").click(function () {
                custinfo_form.send();
            });
        },
        send: function () {
            var id = $('#id').val();
            var pwd = $('#pwd').val();
            var name = $('#name').val();
            if (id.length <= 3) {
                $('#check_id').text('4자리 이상이어야 합니다.');
                $('#id').focus();
                return;
            }
            if (pwd == '') {
                $('#pwd').focus();
                return;
            }
            if (name == '') {
                $('#name').focus();
                return;
            }
            $("#custinfo_form").attr({
                "action": "/custinfoimpl",
                "method": "post"
            });
            $("#custinfo_form").submit();
        }
    }

    $(function () {
        custinfo_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <form id="custinfo_form" class="">
            <div class="container">
                <p>Cust Info Page</p>
                <hr>

                <label for="id"><b>ID</b></label>
                <input type="text" value="${custinfo.id}" name="id" id="id" readonly>

                <div>
                    <span id="check_id" class="bg-danger"></span>
                </div>

                <label for="pwd"><b>Password</b></label>
                <input type="password" name="pwd" id="pwd" required>

                <label for="name"><b>Name</b></label>
                <input type="text" value="${custinfo.name}" name="name" id="name" required>
                <hr>

                <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
                <button id="custinfo_btn" type="button" class="custinfo_btn">Update</button>
            </div>
        </form>
    </div>
</div>

<style>
    * {
        box-sizing: border-box
    }

    /* Add padding to containers */
    .container {
        padding: 16px;
        width: 100%;
        height: 100%;
    }

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Overwrite default styles of hr */
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* Set a style for the submit/register button */
    .registerbtn {
        background-color: #04AA6D;
        color: white;
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .registerbtn:hover {
        opacity: 1;
    }

    /* Add a blue text color to links */
    a {
        color: dodgerblue;
    }

    /* Set a grey background color and center the text of the "sign in" section */
    .signin {
        background-color: #f1f1f1;
        text-align: center;
    }
</style>