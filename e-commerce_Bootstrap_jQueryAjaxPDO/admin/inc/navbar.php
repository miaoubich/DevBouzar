	<!-- navigathion menu -->
	<?php
	echo'<nav class="navbar navbar-inverse" style="margin-bottom: 0!important;">
			<div class="container-fluid">
				<div class="navbar-head">
					<button type="submit" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">CRUD</a>
				</div>

				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">1</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">2
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">2.1</a></li>
								<li><a href="#">2.2</a></li>
								<li><a href="#">2.3</a></li>
							</ul>
						</li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li></li>
						<li></li>
					</ul>

					<!-- Trigger the modal with a button -->
					<button type="button" id="add_button" data-toggle="modal" data-target="#userModal" class="btn btn-default" style="margin-top:7px;">Add New Employee</button>
					<!--
					<form class="navbar-form navbar-left" action="/action_page.php">
					  <div class="input-group">
					    <input type="text" class="form-control" placeholder="Search">
					    <div class="input-group-btn">
					      <button class="btn btn-default" style="height:34px;" type="submit">
					        <i class="glyphicon glyphicon-search"></i>
					      </button>
					    </div>
					  </div>
					</form>
					-->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"> Sign-up</span></a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"> Sign-in</span></a></li>
					</ul>
				</div>
			</div>
		</nav>';
	?>