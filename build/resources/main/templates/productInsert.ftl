
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


</head>

<body>

<#--<#include "views/navibar.html" >-->

<!-- Page Content -->
<div class="container">

    <div class="row">
        <#include "views/navibar.html" >

        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <form method="post" action="/product/add" enctype="multipart/form-data">
                <div class="card mt-4">
                    <div class="card my-4">
                        <h5 class="card-header">상품명</h5>
                        <div class="card-body">
                            <div class="input-group">
                                <input type="text" id="productName" class="form-control" >

                            </div>
                        </div>
                        <h5 class="card-header">그룹코드</h5>
                        <div class="card-body">
                            <div class="input-group">
                                <input type="text" id="productGroupCode" class="form-control" placeholder="대문자 7자리">

                            </div>
                        </div>
                        <h5 class="card-header">가격</h5>
                        <div class="card-body">
                            <div class="input-group">
                                <input type="text" id="price" class="form-control" >

                            </div>
                        </div>
                        <h5 class="card-header">옵션</h5>
                        <div class="card-body">
                            <div class="input-group" >
                                <div>
                                    <div style="float: left;"><input type="text" class="form-control"  name="productOption" placeholder="옵션입력"></div>
                                    <div style="float: left;"><input type="text" class="form-control"  name="productStock" placeholder="재고입력"></div>
                                </div>
                                <span class="input-group-append">
                                    <button class="btn btn-secondary" type="button" onclick="setOption()">옵션추가</button>
                                </span>
                            </div>
                            <div id="optionView"></div>
                        </div>
                        <h5 class="card-header">설명</h5>
                        <div class="card-body">
                            <div class="input-group">
                                <input type="text" id="description" class="form-control" >

                            </div>
                        </div>
                        <h5 class="card-header">이미지등록</h5>
                        <div class="card-body">
                            <div class="input-group">
                                <input type="file" id="fileInput" class="image_inputType_file" accept="img/*" >

                            </div>
                        </div>
                        <input type="submit" class="btn btn-success" id="sendButton" value="등록"/>
                    </div>
                </div>
            </form>
        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    function setOption() {
        var html = "<div><div style=\"float: left;\"><input type=\"text\" class=\"form-control\"  name=\"productOption\" placeholder=\"옵션입력\"></div>"+
        "<div style=\"float: left; margin-right: 300px;\"><input type=\"text\" class=\"form-control\"  name=\"productStock\" placeholder=\"재고입력\"></div></div>";
        $('#optionView').append(html);
    }
    var fileInput = document.querySelector("#fileInput");
    var sendButton = document.querySelector("#sendButton");

    sendButton.addEventListener("click",function(){
        var optionValue = $("input[name='productOption']").length;
        var optionData = new Array(optionValue);
        var stockData = new Array(optionValue);
        for(var i=0; i<optionValue; i++){
            optionData[i] = $("input[name='productOption']")[i].value;
            stockData[i] = $("input[name='productStock']")[i].value;
        }


        var formData = new FormData();
        // form Data 객체 생성
        formData.append("image",document.getElementById('fileInput').files[0]);
        formData.append("productName", $('#productName').val());
        formData.append("productGroupCode", $('#productGroupCode').val());
        formData.append("price", $('#price').val());
        formData.append("description", $('#description').val());
        formData.append("productOption", optionData);
        formData.append("amount", stockData);

        $("#sendButton").prop("disabled", true);

        $.ajax({
            url:"/product/add", // 요청 할 주소
            async:true,// false 일 경우 동기 요청으로 변경
            type:'POST', // GET, PUT
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            data: formData,// 전송할 데이터
            //beforeSend:function(jqXHR) {},// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
            success:function(data) {
                alert(data.msg);
                if(data.msg == 'SUCCESS') {
                    location.href="/product/list";
                }
            },// 요청 완료 시
            //error:function(jqXHR) {},// 요청 실패.
            //complete:function(jqXHR) {}// 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
        });

    });

</script>