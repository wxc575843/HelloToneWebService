/**
 * 
 */
$(function(){
	var college_chosen = null;
	var dept_chosen = null;

	var college_modify_chosen = null;
	var dept_modify_chosen = null;
	var college_modify_chosen_name = "";
	var dept_modify_chosen_name = "";
	var gid="";
	
});

$(window).load(function(){
	
});


function removeFormatter(value, row, index) {
//	alert(index);
    return [
        '<a class="remove" style="text-decoration:none" title="删除">',
            '<i class="glyphicon glyphicon-trash"></i>',
        '</a>'
    ].join('');
    
}

function modifyFormatter(value, row, index) {
    return [
        '<a class="modify" style="text-decoration:none" href=# title="修改" data-toggle="modal" data-target="#modifyModal">',
            '<i class="fa fa-pencil"></i>',
        '</a>'
    ].join('');
}

window.articleRemoveEvents = {
		'click .remove': function (e, value, row, index) {
			var id = row['id'];
//			alert(id);
			$.ajax({
				url: "servlet/DeleteArticleServlet", //后台交互页面 
			    type: "POST", //请求方式
			    data: "id="+id,
			    success: function (result) {
				    	$('#table').bootstrapTable('refresh',null);
//			    	alert("");
			    }
			});
	}

}

window.modifyEvents = {
		'click .modify': function (e, value, row, index) {
			$("#modify_title").attr('value', row['title']);
			$("#modify_author").attr('value', row['author'].toString());
			$("#modify_content").attr('value', row['content'].toString());
			$("#modify_picture").attr('value', row['picture'].toString());			
			$("#modify_id").attr('value', row['id'].toString());			
			
		}

}

function modifyClick(){		
	var title = $("#modify_title").val();
	var author = $("#modify_author").val();
	var aclass = $("#modify_class").val();
	var top = $("#modify_top").val();
	var content = $("#modify_content").val();
	var picture = $("#modify_picture").val();
	var id = $("#modify_id").val();
	
	alert(author);
		$.ajax({
			url: "servlet/ModifyArticleServlet", //后台交互页面 
		    type: "POST", //请求方式
		    data:
		    "title=" + title +
		    "&gid" + id + 
		    "&author=" + author +
		    "&aclass=" + aclass +
		    "&top=" + top +
		    "&content=" + content +
		    "&picture=" + picture ,
		    success: function (result) {
			    	$('#table').bootstrapTable('refresh',null);
		    	
		    }
		});
	
	
}

function confirmClick(){
	var title = $("#add_title").val();
	var author = $("#add_author").val();
	var top = $("#select_top").val();
	var aclass = $("#select_class").val();
	var content = $("#add_content").val();
	var picture = $("#add_picture").val();
	
	alert(content);
	if(title == "" || author ==""||top==""|| aclass == ""||content == ""){
		alert("不能有空着的信息");
		
	}
	else{
		$.ajax({
			url: "servlet/AdminAddArticleServlet", //后台交互页面 
		    type: "POST", //请求方式
		    data: "author=" + author +
		    "&title=" + title +
		    "&top=" + top +
		    "&aclass=" + aclass +
		    "&content=" + content +
		    "&picture=" + picture ,
		    success: function (result) {
		    	
		    		alert("添加成功");
			    	$('#table').bootstrapTable('refresh',null);
		    	
		    }
		});
		
	}
		
	
	
}

