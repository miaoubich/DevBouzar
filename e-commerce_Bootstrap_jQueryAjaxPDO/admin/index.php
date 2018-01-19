<!DOCTYPE>
<html>
<div id="empty-grey-div" style=""></div>
	<head>
		<title>Project jQuery/Ajax</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/footer.css">
		<link rel="stylesheet" href="css/sideBar.css">
		
		<!-- Bootstrap -->
		<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->
		<link href="js/css/bootstrap.min.css" rel="stylesheet">

		<!-- font-awesome -->
		<!--<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">-->
		<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css" />

	</head>

	<body style="background:#f2f2f7">
	
	<?php
		include("inc/db.php");	
		include("inc/function.php");
		include("inc/navbar.php");
		include("inc/sideBar.php");
		include("inc/ModelForm.php");
	?>
		<div id="bodyhead">
			
			<br/>
			<br/>
			<div class="container">
				<div class="container">
					<p id="alert" style="display:none;" class="alert alert-success text-center"><i class="glyphicon glyphicon-ok"></i><span id="show"></span></p>
				</div>
			</div>
		</div>

		<div id="bodyleft">
			
		</div>

		<div id="bodyright">
			<div class="table-responsive">
				<table id="user_data" class="table table-bordered table-striped">
				    <thead>
				     	<tr>
				       		<th width="10%"><center>Image</center></th>
				        	<th width="35%">First Name</th>
				        	<th width="35%">Last Name</th>
				        	<th width="10%"><center>Edit</center></th>
				        	<th width="10%"><center>Delete</center></th>
				       	</tr>
				    </thead>
				</table>
			</div>
		</div>

		<br clear="all"/>
		
		<?php
			include("inc/footer.php");
		?>




		
		<script src="js/jQuery-3.2.1.js"></script>
		<script src="js/bootstrap-3.3.7.js"></script>
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  		<script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
  		<script src="js/MyjQuery.js"></script>
  		<script type="text/javascript" language="javascript">

			function Sidebar(){
				document.getElementById("wrapper").classList.toggle('active');
				$('#empty-grey-div').fadeIn('slow');
				
			}

			// If user clicks anywhere outside of the sign-in or sign-up, it will close
	
			var greyDiv = document.getElementById('empty-grey-div');

			window.onclick = function(event){

				if (event.target == greyDiv){
					greyDiv.style.display = "none";
					document.getElementById("wrapper").classList.toggle('active');
				}
			}
			
		</script>
	</body>
</html>