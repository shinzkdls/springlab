login.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    $(function () {
        login_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <form action="/ocr1impl" enctype="multipart/form-data" id="ocr1_form" class="" method="post">
            <div class="imgcontainer">
                <h1>OCR1</h1>
                <h2>${result.biznum}</h2>
                <h2>${result.bizname}</h2>
                <h2>${result.bizowner}</h2>
                <h2>${result.bizdate}</h2>
                <h2>${result.bizadd}</h2>

            </div>

            <div class="container">
                <label for="img"><b>Image</b></label>
                <input type="file" id="img" name="img" placeholder="Input Image" required>
            </div>
            <button id="ocr1_btn" type="submit">Send</button>
        </form>
    </div>
</div>


<style>
    /* Bordered form */
    form {
        border: 3px solid #f1f1f1;
    }

    /* Full-width inputs */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }

    /* Extra style for the cancel button (red) */
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    /* Center the avatar image inside this container */
    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    /* Avatar image */
    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    /* Add padding to containers */
    .container {
        padding: 16px;
        width: 100%;
        height: 100%;
    }

    /* The "Forgot password" text */
    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }

        .cancelbtn {
            width: 100%;
        }
    }
</style>