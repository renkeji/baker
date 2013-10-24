$(function() {
	$(window).load(function() {
		var current_page = window.location;
		var path_name = current_page.pathname.substring(current_page.pathname.lastIndexOf('/')+1, current_page.pathname.length);
		$("li[id='"+path_name+"']").addClass("highlight");
	});
});

$(function() {
	$(window).unload(function() {
		$(["class *= 'highlight'"]).removeClass("highlight");
	});
});