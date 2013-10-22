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

/*
 * For pli report data, make ajax call to pass the backend data to front var
 * 
 * $(a.pli_link).onclick = function() {
 * 		$.ajax({
 * 			url:
 * 
 * }
 *	
 * Plot a bar chart using jqBarGraph:
 * $("#divbarchart).jqBarGraph({data : <input data in array format>});
 */
//arrayOfData = new Array([10.3, 'jan', '#f3f3f3'], [15.2, 'feb', '#f4f4f4']);
//$(function() {
//	$("a[id = 'pli_report_link']").click(function() {
//		$("div[id = 'pli-bar-chart']").jqBarGraph({data : arrayOfData});
//	});
//});
//
//$(function() { 
//	$("div[id = 'pli-bar-chart']").jqBarGraph({data : arrayOfData});
//});