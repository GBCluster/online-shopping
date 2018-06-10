<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
	
			<div class="col-lg-12">
			
				<ol class="breadcrumb">
				
				
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
					<li class="breadcrumb-item active">${product.name}</li>
				
				</ol>
			
			
			
			</div>
	
	
	</div>


	<div class="row">
			<!-- Display the product image -->
			<div class="col-sm col-sm">
			
				<div class="img-thumbnail img-fluid">
				
					<img src="${images}/${product.code}.jpg" class=" mx-auto d-block singleProduct"/>
				
				
				</div>
				
			
			</div>
			
			<!-- Display the product description -->
			<div class="col-sm col-sm">
			
			
				<h3>${product.name}</h3>
				<hr/>
				
				<p>${product.description}</p>
				<hr/>
				
				<h4>Price : <strong> &#8377; ${product.unitPrice} /-</strong></h4>
				<hr/>
				
				<c:choose>
				
					<c:when test="${product.quantity < 1 }">
						
						<h6>Qty. Available: <span style="color:red">Out Of Stock!</span></h6>
						
						</c:when>
						
						<c:otherwise>
						
						<h6>Qty. Available:  ${product.quantity}</h6>
				
						</c:otherwise>
				
				</c:choose>
				
				
				<c:choose>
				
					<c:when test="${product.quantity < 1 }">
						
						<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
						<span class="fa fa-cart-plus"></span> Add to Cart</strike></a>
						
						</c:when>
						
						<c:otherwise>
						
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
						<span class="fa fa-cart-plus"></span> Add to Cart</a>
				
						</c:otherwise>
				
				</c:choose>
				
				
				
				
				<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
							 
			</div>

</div>