$(document).ready(function(){
	$('#add_button').click(function(){
		$('#user_form')[0].reset();
		$('.modal-title').text("Add User");
		$('#action').val("Add");
		$('#operation').val("Add");
		$('#user_uploaded_image').html('');
	});
 
	var dataTable = $('#user_data').DataTable({
		"processing":true,
		"serverSide":true,
		"order":[],
		"ajax":{
				url:"fetch.php",
				type:"POST"
				},
			"columnDefs":[
				{
				"targets":[0, 3, 4],
				"orderable":true,
				},
			],

	});

$(document).on('submit', '#user_form', function(event){
	event.preventDefault();
	var firstName = $('#first_name').val();
	var lastName = $('#last_name').val();
	var extension = $('#user_image').val().split('.').pop().toLowerCase();
	
	if(extension != ''){
		if(jQuery.inArray(extension, ['gif','png','jpg','jpeg']) == -1){
			alert("Invalid Image File");
			$('#user_image').val('');
			
			return false;
		}
	} 
	if(firstName != '' && lastName != ''){
		$.ajax({
			url:"insert.php",
			method:'POST',
			data:new FormData(this),
			contentType:false,
			processData:false,
			success:function(data){
				alert(data);
				$('#user_form')[0].reset();
				$('#userModal').modal('hide');
				dataTable.ajax.reload();
			}
		});
	}else{
		alert("Both Fields are Required");
	}
});
 
$(document).on('click', '.update', function(){
	var user_id = $(this).attr("id");
	
	$.ajax({
		url		:"fetch_single.php",
		method	:"POST",
		data	:{user_id:user_id},
		dataType:"json",
		success	:function(data){
			$('#userModal').modal('show');
			$('#first_name').val(data.first_name);
			$('#last_name').val(data.last_name);
			$('.modal-title').text("Edit User");
			$('#user_id').val(user_id);
			$('#user_uploaded_image').html(data.user_image);
			$('#action').val("Edit");
			$('#operation').val("Edit");
		}
	})
});
 
 $(document).on('click', '.delete', function(){
  var user_id = $(this).attr("id");
  if(confirm("Are you sure you want to delete this?"))
  {
   $.ajax({
    url:"delete.php",
    method:"POST",
    data:{user_id:user_id},
    success:function(data)
    {
     alert(data);
     dataTable.ajax.reload();
    }
   });
  }
  else
  {
   return false; 
  }
 });
 
 
});

/*
$(document).ready(function(){
	//reset Employee form
	$('#add_button').click(function(){
		$('#user_form')[0].reset();
		$('.modal-title').text("Add an Employee");
		$('#action').val("Add");
		$('#operation').val("Add");
		$('#user_uploaded_image').html('');
	});
	//Validation
	var fname = $("#Fname");
	var lname = $("#Lname");
	var gender = $("#gender");
	
	$("#Fname").blur(function(){
		if(fname.val() == ""){
			fname.css("border", "1px solid red");
			$('#action').attr("disabled", true);
		}else{
			$('#action').attr("disabled", false);
			fname.css("border", "");
		}
		
	});

	$("#Lname").blur(function(){
		if(lname.val() == ""){
			lname.css("border", "1px solid red");
			$('#action').attr("disabled", true);
		}else{
			$('#action').attr("disabled", false);
			lname.css("border", "");
		}	
	});
	//End of Validation

	//if(isNotEmpty(fname.val()) && isNotEmpty(lname.val()) ){
	//	... code for ajax here
	//}

	//Add new employee
	$("#action").click(function(){
		var fname = $("#Fname").val();
		var lname = $("#Lname").val();
		var gend = $("#gender").val();
		var extension = $("#user_image").val().split(".").pop().toLowerCase();
		
		if(extension !=""){
			if(jQuery.inArray(extension, ["gif","png","jpg","jpeg"])){
				alert("Invalid Image File");
				$("#user_image").val("");

				return false;
			}
		}

		$.ajax({
			type	: "POST",
			data	: {Firstname:fname, Lastname:lname, Gender:gend},
			url 	: "ajax.php",
			dataType:"json",
			success : function(result){//response from this request will be saved in result
						//show success message
						$("#alert").show();
						//print result in span having id="show"
						$("#show").html(result);
					  },
			async: false //to make jquery synchronized with ajax
		});
	});

	//Display dataTable
	$('#user_data').dataTable(
            {
             "aaSorting": [[0, "asc"],[1,"asc"]],
             "bPaginate": true,
             "bLengthChange": true,
             "bFilter":true,
             "bSort":true,
             "bInfo":true,
             "bAutoWidth":true
            });

	/*function getExistingData(start, limit){
		$.ajax({
			type	: "POST",
			url 	: "ajax.php",
			data    : {
						key: "getExistingData",
						start: start,
						limit: limit
					   },
			success : function(response){
				 if(response != "reachedMax"){
				 	$("#tbody").append(response);
				 	start += limit;
				 	getExistingData(start, limit);
				 }
			}		  
			
		});
	}*/
//});


	