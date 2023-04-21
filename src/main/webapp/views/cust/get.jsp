<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        //register_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h1>Detail Page</h1>
        <form id="update_form" class="">
            <div class="container">
                <p>Please fill in this form to create an account.</p>
                <hr>

                <label for="id"><b>ID</b></label>
                <input type="text" value="${gcust.id}" name="id" id="id" required readonly>

                <label for="pwd"><b>Password</b></label>
                <input type="password" value="${gcust.pwd}" name="pwd" id="pwd" required>

                <label for="name"><b>Name</b></label>
                <input type="text" value="${gcust.name}" name="name" id="name" required>
                <hr>

                <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
                <button id="update_btn" type="button" class="registerbtn">Update</button>
                <button id="remove_btn" type="button" class="registerbtn">Delete</button>
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