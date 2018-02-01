<?php
echo'<div id="wrapper">
			<div id="sidebar">
					<div class="toggle-btn" id="humbtn" onclick="Sidebar()">
						<span></span>
						<span></span>
						<span></span>
					</div>
					
					<ul  style="overflow:scroll; width:auto; height:100%;">
						<li style="line-height: 35px;width:5px !important;">
							<!--<div class="toggle-btn1" id="humbtn" onclick="Sidebar()" ">
								<span></span>
								<span></span>
								<span></span>
							</div>-->
							<span style="width:40px;color:#000;">.</span>
						</li>
						<li><a href="#"> <span><span class="glyphicon glyphicon-envelope"> </span> Account</a></li>
						<li><a href="#"> <span class="glyphicon glyphicon-cog"> </span> Setting</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-th-list"> </span> Users List</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-user"> </span> Moderator</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-user"> </span> User</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-list-alt"> </span> Requests</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-shopping-cart"> </span> Purchases</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-unchecked"> </span> Points</a></li>
						<li><a href="#.php"> <span class="glyphicon glyphicon-stats"> </span> Statistics</a></li>
						<li><a href="#"> <span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
					</ul>
			</div>
		</div>';
?>