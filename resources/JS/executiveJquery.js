$(document).ready(function(){
  
  /* Clicking the manager's request body will toggle a check*/
  $(".blueCard").click(function(){

    var isChecked = $(".selectBox", this).prop("checked");
    $(".selectBox", this).prop('checked', !isChecked);
  });

  $(".selectBox").click(function(){
    var isChecked = $(this).prop("checked");
    $(this).prop("checked", !isChecked);
  });

  $(".detailBtn").click(function(){
    $("span", this).toggleClass("glyphicon glyphicon-arrow-down").toggleClass("glyphicon glyphicon-arrow-right");
  })

  $(".toExecutiveProgress").click(function(){
    $(this).submit();
  });

  $(".toExecutiveDashboard").click(function(){
    window.location="executive_dashboard.html";
  });
})