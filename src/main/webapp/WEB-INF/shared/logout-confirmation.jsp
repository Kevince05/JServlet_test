<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
	$(document).ready(
			function() {
				// Show dialog to confirm logout:
				modalLogout = new bootstrap.Modal(document
						.getElementById('modalLogout'), {
					backdrop : 'static', //don’t close modal if user click outside
					keyboard : false
				// can’t even press esc from keyboard
				})
				$(document).on("click", "#logout", function(event) {
					event.preventDefault(); // prevent default action
					modalLogout.show(); // show modal window
				});

				$(document).on("click", "#modal-form", function(event) {
					modalLogout.hide(); // hide modal window
				});
			});
</script>
<div id="modalLogout" class="modal" tabindex="-1"
	data-bs-backdrop="static" data-bs-keyboard="false">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Confirm Logout</h5>
			</div>
			<div class="modal-body">
				<p id="modal-message">Are you sure you want to logout?</p>
			</div>
			<div class="modal-footer">
				<form method="POST">
					<button id="modal-form" type="submit" class="btn btn-primary">Cancel</button>
					<button id="modal-form" type="submit" class="btn btn-danger" name="request" value="Logout">Logout</button>
				</form>
			</div>
		</div>
	</div>
</div>
