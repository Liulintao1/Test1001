<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="resources/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/js/bootstrap/css/bootstrap-theme.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/jqueryExt.js"></script>
<script type="text/javascript" src="resources/jquery.form.js"></script>
<script type="text/javascript">
	$(function() {
		findGoods();
		findType();
	})
	/* 查询 */
	function findGoods() {
		$.ajax({
			url : "goods/queryAll",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#showBody").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					var obj = ary[i];
					var tr = "<tr>";
					tr += "<td>" + obj.goodsid + "</td>";
					tr += "<td>" + obj.typename + "</td>";
					tr += "<td>" + obj.goodsname + "</td>";
					tr += "<td>" + obj.goodsdesc + "</td>";
					tr += "<td>" + obj.goodsunitprice + "</td>";
					tr += "<td>" + obj.goodsimagename + "</td>";
					tr += "<td><image src='" + obj.goodsimagename + "' style='height:30px;weight:45px;'/></td>";
					tr += "<td>" + obj.goodsdate + "</td>";
					tr += "</tr>";
					$("#showBody").append(tr);
				}
			}
		})
	}

	/* 查询类别 */
	function findType() {
		$.ajax({
			url : "goods/queryType",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#goodstype").html("");
				var ary = data;
				for (var i = 0; i < ary.length; i++) {
					$("#goodstype").append("<option value='" + ary[i].typeId + "' >" + ary[i].typeName + "</option>");
				}
			}
		})
	}
	/* 录入 */
	/* 
	function addGoods() {
		var obj = $("#Goodsform").serializeObject();
		$.ajax({
			url : "goods/insert",
			type : "post",
			async : true,
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(obj),
			dataType : "text",
			success : function() {
				$(".closemodal").click();
				findGoods();
			}
		})
	}
	 */
	/* 录入*/
	function addGoods() {
		$("#Goodsform").ajaxSubmit({
			url : "goods/insert",
			type : "post",
			async : true,
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			dataType : "text",
			success : function() {
				$(".closemodal").click;
				findGoods();
			}
		})
	}
</script>
</head>

<body>
	<!-- 查询显示 -->
	<div>
		<table class="table table-hover">
			<caption>人员信息</caption>
			<thead>
				<tr>

					<th>商品编号</th>
					<th>商品类别</th>
					<th>商品名称</th>
					<th>商品描述</th>
					<th>商品价格</th>
					<th>图片地址</th>
					<th>商品图片</th>
					<th>生产日期</th>
				</tr>
			</thead>

			<tbody id="showBody">

			</tbody>
		</table>
	</div>
	<!-- 修改模态 -->
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal" id="clean">添加商品</button>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加窗口</h4>
				</div>
				<div class="modal-body">
					<form class="bs-example bs-example-form" role="form" id="Goodsform"
						enctype="multipart/form-data">
						<div class="input-group">
							<span class="input-group-addon">ID</span> <input
								readonly="readonly" type="text" class="form-control"
								disabled="disabled" name="goodsid" id="id">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">商品名称</span> <input type="text"
								class="form-control" placeholder="请输入商品名称" name="goodsname"
								id="name">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">商品类别</span> <select
								class="form-control" id="goodstype" name="typeid"></select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">商品描述</span> <input
								placeholder="请输入商品描述" class="form-control" name="goodsdesc">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">商品图片</span> <input type="file"
								class="form-control" name="goodsimage">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">商品价格</span> <input
								placeholder="请输入商品价格" class="form-control" name="goodsunitprice"
								id="birthday"><span class="input-group-addon">元</span>
						</div>
						<br>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default closemodal"
						data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="addGoods()">提交修改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>