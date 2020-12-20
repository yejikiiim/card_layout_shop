
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ShoppingMall</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/shop-homepage.css" rel="stylesheet">

</head>

<include />
<body>

<div id="headers"></div>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <h1 class="my-4">쇼핑몰</h1>
            <div class="list-group">
                <a href="#" class="list-group-item">의류</a>
                <a href="#" class="list-group-item">잡화</a>
                <a href="#" class="list-group-item">문의</a>
            </div>

            <div style="float: right; margin-right: 40px; margin-top: 30px;">
                <span class="text-warning">
                    <a href="/product/insert" class="btn btn-warning">상품등록하기</a>
                </span>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">


            <div class="row" id="productCard">
                <#if result.result.productList??>
                <#list result.result.productList as data>
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="/product/${data.groupCode}"><img class="card-img-top" <#if data.image??> src="/product/resources/img/${data.image}" </#if> alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="/product/${data.groupCode}">${data.productName}</a>
                            </h4>
                            <h5>${data.price}</h5>

                        </div>
                    </div>
                </div>
                </#list>
                </#if>

            </div>
            <!-- /.row -->

            <div style="text-align: center;"><button id="moreProduct" onclick="getProductList()">more</button></div>
        </div>
        <!-- /.col-lg-9 -->
    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    function getProductList(){
        var offset = $(".card-body").length + 1;
        $.ajax({
            url:"/product/list/"+offset, // 요청 할 주소
            async:true,// false 일 경우 동기 요청으로 변경
            type:'GET', // GET, PUT
            dataType:'json',// xml, json, script, html
            beforeSend:function(jqXHR) {},// 서버 요청 전 호출 되는 함수 return false; 일 경우 요청 중단
            success:function(data) {
                var totalCount = data.result.totalCount;
                if(totalCount != 0) {
                    for(var i=0; i<totalCount; i++) {
                        var html = "<div class=\"col-lg-4 col-md-6 mb-4\"><div class=\"card h-100\">"+
                            "<a href=\"/product/"+data.result.productList[i].groupCode+"\"><img class=\"card-img-top\" src=\"/product/resources/img/"+data.result.productList[i].image+"\" alt=\"\"></a>"+
                            "<div class=\"card-body\"><h4 class=\"card-title\"><a href=\"/product/"+data.result.productList[i].groupCode+"\">"+data.result.productList[i].productName+"</a>"+
                            "</h4><h5>"+data.result.productList[i].price+"</h5></div></div></div>";

                        $('#productCard').append(html);


                    }

                    if(totalCount < 9) {
                        document.getElementById('moreProduct').style.visibility = 'hidden';
                    }
                }

            },// 요청 완료 시
            error:function(jqXHR) {},// 요청 실패.
            complete:function(jqXHR) {}// 요청의 실패, 성공과 상관 없이 완료 될 경우 호출
        });


    }
</script>