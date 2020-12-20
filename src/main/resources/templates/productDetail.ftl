
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

            <div class="card mt-4">
                <img class="card-img-top img-fluid" <#if result.result.image??> src="/product/resources/img/${result.result.image}" </#if> alt="">
                <div class="card-body">
                    <h3 class="card-title">${result.result.productName}</h3>
                    <h4>${result.result.price}</h4>
                    <input type="hidden" id="hiddenPrice" value="${result.result.price}" />
                    <div class="input-group">
                        <div style="float:left">
                          <select class="form-control" id="productOption">
                              <option value="">선택</option>
                              <#list result.result.productDetailList as data>
                                  <option value="${data.id}">${data.productDetailOption}</option>
                              </#list>
                          </select>
                        </div>
                        <div style="float:left">
                            <input type="text" id ="productAmount" class="form-control" placeholder="수량 입력" />
                        </div>
                    </div>
                    <div class="input-group">
                        <div style="float:left">
                            <input type="text" id ="productCustomerName" class="form-control" placeholder="주문자 이름 입력" />
                        </div>
                        <div style="float:left">
                            <input type="text" id ="productPhoneNum" class="form-control" placeholder="주문자 연락처 입력" />
                        </div>
                    </div>
                    <div>

                        <p class="card-text">${result.result.description}</p>
                    </div>
                    <span class="text-warning"><a href="javascript:buyProduct();" class="btn btn-success">주문하기</a></span>
                    <div style="float: right;"><span class="text-warning" style="text-align: right"><a href="javascript:deleteProduct('${result.result.groupCode}');" class="btn btn-danger">삭제하기</a></span></div>
                    <div style="float: right; margin-right: 30px;"><span class="text-warning" style="text-align: right"><a href="/product/update?groupCode=${result.result.groupCode}" class="btn btn-warning">수정하기</a></span></div>
                </div>
            </div>

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
    function removeComma(str) {
        var n = parseInt(str.replace(/,/g,""));
        return n;
    }

    // 상품 주문하기
    function buyProduct(){
        const id = $("#productOption option:selected").val();
        var price = removeComma($('#hiddenPrice').val());
        var totalPrice = price * $('#productAmount').val();
        alert(totalPrice);
        var requestData = {
            amount: $('#productAmount').val(),
            customerName: $('#productCustomerName').val(),
            customerPhoneNum: $('#productPhoneNum').val(),
            totalPrice: totalPrice
        };
        requestData = JSON.stringify(requestData);
        $.ajax({
            url:"/product/buy/"+id, // 요청 할 주소
            async:true,// false 일 경우 동기 요청으로 변경
            type:'PATCH', // GET, PUT
            contentType: 'application/json; charset=utf-8',
            dataType: "text",
            data: requestData,// 전송할 데이터
            //beforeSend:function(jqXHR) {},// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
            success:function(data) {
                var dataObj = JSON.parse(data);
                if(dataObj.code == 204) {
                    alert("재고없음");
                    location.href="/product/list";
                }
                if(dataObj.msg == 'SUCCESS') {
                    location.href="/product/list";
                }
            },// 요청 완료 시
            //error:function(jqXHR) {},// 요청 실패.
            //complete:function(jqXHR) {}// 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
        });
    }

    // 상품 삭제하기
    function deleteProduct(groupCode){
        $.ajax({
            url:"/product/delete/"+groupCode, // 요청 할 주소
            async:true,// false 일 경우 동기 요청으로 변경
            type:'PUT', // GET, PUT
            dataType:'json',// xml, json, script, html
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
    }
</script>