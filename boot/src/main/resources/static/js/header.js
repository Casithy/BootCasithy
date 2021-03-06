$(function(){
	$.ajax({
        type: "GET",
        url: "/user/loginUserInfo",
        dataType: "json",
        success: function(data){
        	var menus = new Array(data.menus);
        	var result = "";
        	for(var i = 0;i < menus.length; i++){
        		for(var item in menus[i]){
        			if(menus[i][item].level == 1){
        				var num = judgeTheMenu(menus[i][item].id,menus);
        				if(num == 0){
        					result += "<ul class='nav navbar-nav'> ";
        					result += "<li><a href='"+ menus[i][item].href +"'>"+ menus[i][item].text +"</a></li> </ul>"
        				}
        				else{
        					result += "<ul class='nav navbar-nav'> <li class='active'></li>";
        					result += "<li class='dropdown'>";
        					result += "<a href='"+ menus[i][item].href +"' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-expanded='false'>"+ menus[i][item].text +"<span class='caret'></span></a>";
        					result += loadAMenu(menus[i][item].id,menus);
        					result += "</li>";
        					result += "</ul>";
        				}
        			}
        		}
        	}
        	result += "<ul class='nav navbar-nav navbar-right'><li><a href='/logout'>退出</a></li></ul>";
        	result += "<ul class='nav navbar-nav navbar-right'><li><a href='#'>"+ data.username +"</a></li></ul>";
        	document.getElementById("menus").innerHTML = result;
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
        	var result = "";
        	result += "<ul class='nav navbar-nav navbar-right'><li><a href='/login.html'>登录</a></li></ul>"
        	document.getElementById("menus").innerHTML = result;
        }
   });
});
function judgeTheMenu(menusId,menus){
	var num = 0;
	for(var i = 0;i < menus.length; i++){
		for(var item in menus[i]){
			if(menus[i][item].parentId == menusId){
				num = num + 1;
			}
		}
	}
	return num;
}
function loadAMenu(menusId,menus){
	var result = "<ul class='dropdown-menu' role='menu'>";
	for(var i = 0;i < menus.length; i++){
		for(var item in menus[i]){
			if(menus[i][item].parentId == menusId){
				result += "<li><a href='"+ menus[i][item].href +"'>"+ menus[i][item].text +"</a></li>"
			}
		}
	}
	result += "</ul>";
	return result;
}