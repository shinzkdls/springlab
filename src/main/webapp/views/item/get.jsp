<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let item_get = {
        init: function () {
            $('#cart_btn').click(function () {
                // $('#cart_form').attr({
                //     method: 'get',
                //     action: '/item/addcart'
                // });
                // $('#cart_form').submit();
                let cust_id = '${logincust.id}';
                let item_id = ${gitem.id};
                let cnt = $('#cnt').val();
                $.ajax({
                    url: '/addcart',
                    data: {cust_id: cust_id, item_id: item_id, cnt: cnt},
                    success: function () {
                        $('#myModal').modal();
                    }
                });
            });
        }
    };

    $(function () {
        item_get.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Item Info</h3>
        <img src="/uimg/${gitem.imgname}">
        <h4>${gitem.id}</h4>
        <h4>${gitem.name}</h4>
        <h4>${gitem.price}</h4>
        <c:if test="${logincust != null}">
            <form id="cart_form" class="form-inline well" method="post">
                <input type="hidden" name="cust_id" value="${logincust.id}">
                <input type="hidden" name="item_id" value="${gitem.id}">
                <div class="container">
                    <label for="cnt"><b>Count</b></label>
                    <input type="number" placeholder="Enter Count" id="cnt" name="cnt" required>
                </div>
                <button id="cart_btn" type="button">Cart</button>
            </form>
        </c:if>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <a href="/item/allcart?id=${logincust.id}" class="btn btn-info" role="button">장바구니로 이동</a>
                <a href="/item/allpage" class="btn btn-info" role="button">계속 쇼핑하기</a>
            </div>
            <div class="modal-footer">
            </div>
        </div>

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