		<!-- Modal -->
		<?php
		echo'<div id="userModal" class="modal Fade">
				<div class="modal-dialog">
					<!-- Modal content-->
					<form method="POST" id="user_form" enctype="multipart/form-data">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<center><h4 class="modal-title">Add User</h4></center>
							</div>
							<!-- modal body -->
							<div class="modal-body">
								<label>Firstname</label>
								<input type="text" id="first_name" name="first_name" class="form-control">
								<br/>
								<label for="">Lastname</label>
								<input type="text" id="last_name" name="last_name" class="form-control">
								<br/>
								<!--
								<label for="" class="control-label">Gender</label>
								<select id="gender" name="gender" class="form-control">
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select> 
								<br/>
								-->
								<label>Select User Image</label>
								<input type="file" id="user_image" name="user_image">
								<span id="user_uploaded_image"></span>
							</div>
							<!-- modal footer -->
							<div class="modal-footer">
								<input type="hidden" name="user_id" id="user_id" />
							 	<input type="hidden" name="operation" id="operation" />
								<input type="submit" id="action" name="action" class="form-control btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>';
		?>