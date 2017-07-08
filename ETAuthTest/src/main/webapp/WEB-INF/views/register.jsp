<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<div class="fh5co-project">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 text-center" style="padding-top: 100px">
						<div class="" style="background-image:  url(${pageContext.request.contextPath}/resources/images/project-2.jpg);">
<!-- 							<div class="desc"> -->
								<h3  style="text-align: center;">Login</h3>
									<form class="contact-form"  action="/auth/submitLoginForm.html" method="post">
									<div class="form-group">
										<label for="email" class="sr-only">Email</label> <input type="text"
											class="form-control" required="required" name="name" id="email"
											placeholder="Email">
									</div>
									<div class="form-group">
										<input type=text style="visibility: hidden;
											class="btn btn-send-message btn-md" value="">
									</div>
									<div class="form-group">
										<label for="pwd" class="sr-only">Password</label> <input
											type="password" name="pwd" required="required" class="form-control"
											id="pwd" placeholder="Password">
									</div>	
									<div class="form-group">
										<input type=text style="visibility: hidden; "
											class="btn btn-send-message btn-md" value="">
									</div>
									
									<div class="form-group">
										<input type="submit" id="btn-submit"
											class="btn btn-send-message btn-md" value="Login">
									</div>
									</form>

<!-- 							</div> -->
							</div>
							</div>
							<div class="col-md-6 text-center" style="padding-top: 100px">
						<div class="" style="background-image:  url(${pageContext.request.contextPath}/resources/images/project-5.jpg);">
<!-- 							<div class="desc"> -->
								<h3 style="text-align: center;">Register</h3>
									<form class="contact-form" action="/auth/submitRegisterForm.html"
										method="post">
										<div class="form-group">
											<label for="name" class="sr-only">Name</label> <input type="text"
												class="form-control" required="required" name="name" id="name"
												placeholder="Name">
										</div>
										<div class="form-group">
											<label for="email" class="sr-only">Email</label> <input type="email"
												name="email" required="required" class="form-control" id="email"
												placeholder="Email">
										</div>
										<div class="form-group">
											<label for="pwd" class="sr-only">Password</label> <input
												type="password" name="pwd" required="required" class="form-control"
												id="pwd" placeholder="Password">
										</div>
										<div class="form-group">
											<label for="mobile" class="sr-only">Mobile</label> <input type="text"
												class="form-control" type="text" name="mobile" id="mobile"
												placeholder="Mobile"></input>
										</div>
										<div class="form-group">
											<input type="submit" id="btn-submit"
												class="btn btn-send-message btn-md" value="Register">
										</div>
									</form>

<!-- 							</div> -->
						</div>
						</div>
					
						
					</div>
				</div>
				<h5>${error }</h5>
			</div>	
<%@include file="footer.jsp"%>