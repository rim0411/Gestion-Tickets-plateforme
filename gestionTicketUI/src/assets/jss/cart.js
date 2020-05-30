/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init SVG
5. InitQty


******************************/

// $(document).ready(function()
// {
// 	"use strict";

// 	/* 

// 	1. Vars and Inits

// 	*/

// 	var header = $('.header');

// 	initMenu();
// 	initSvg();
// 	initQty();

// 	setHeader();

// 	$(window).on('resize', function()
// 	{
// 		setHeader();
// 	});

// 	$(document).on('scroll', function()
// 	{
// 		setHeader();
// 	});

// 	/* 

// 	2. Set Header

// 	*/

// 	function setHeader()
// 	{
// 		if($(window).scrollTop() > 91)
// 		{
// 			header.addClass('scrolled');
// 		}
// 		else
// 		{
// 			header.removeClass('scrolled');
// 		}
// 	}

// 	/* 

// 	3. Init Menu

// 	*/

// 	function initMenu()
// 	{
// 		if($('.menu').length)
// 		{
// 			var hamburger = $('.hamburger');
// 			var header = $('.header');
// 			var superContainerInner = $('.super_container_inner');
// 			var superOverlay = $('.super_overlay');
// 			var headerOverlay = $('.header_overlay');
// 			var menu = $('.menu');
// 			var isActive = false;

// 			hamburger.on('click', function()
// 			{
// 				superContainerInner.toggleClass('active');
// 				menu.toggleClass('active');
// 				header.toggleClass('active');
// 				isActive = true;
// 			});

// 			superOverlay.on('click', function()
// 			{
// 				if(isActive)
// 				{
// 					superContainerInner.toggleClass('active');
// 					menu.toggleClass('active');
// 					header.toggleClass('active');
// 					isActive = false;
// 				}
// 			});

// 			headerOverlay.on('click', function()
// 			{
// 				if(isActive)
// 				{
// 					superContainerInner.toggleClass('active');
// 					menu.toggleClass('active');
// 					header.toggleClass('active');
// 					isActive = false;
// 				}
// 			});
// 		}
// 	}

// 	/* 

// 	4. Init SVG

// 	*/

// 	function initSvg()
// 	{
// 		if($('img.svg').length)
// 		{
// 			jQuery('img.svg').each(function()
// 			{
// 				var $img = jQuery(this);
// 				var imgID = $img.attr('id');
// 				var imgClass = $img.attr('class');
// 				var imgURL = $img.attr('src');

// 				jQuery.get(imgURL, function(data)
// 				{
// 					// Get the SVG tag, ignore the rest
// 					var $svg = jQuery(data).find('svg');

// 					// Add replaced image's ID to the new SVG
// 					if(typeof imgID !== 'undefined') {
// 					$svg = $svg.attr('id', imgID);
// 					}
// 					// Add replaced image's classes to the new SVG
// 					if(typeof imgClass !== 'undefined') {
// 					$svg = $svg.attr('class', imgClass+' replaced-svg');
// 					}

// 					// Remove any invalid XML tags as per http://validator.w3.org
// 					$svg = $svg.removeAttr('xmlns:a');

// 					// Replace image with new SVG
// 					$img.replaceWith($svg);
// 				}, 'xml');
// 			});
// 		}	
// 	}

// 	/* 

// 	5. Init Qty

// 	*/

// 	function initQty()
// 	{
// 		if($('.product_quantity').length)
// 		{
// 			var qtys = $('.product_quantity');

// 			qtys.each(function()
// 			{
// 				var qty = $(this);
// 				var sub = qty.find('.qty_sub');
// 				var add = qty.find('.qty_add');
// 				var num = qty.find('.product_num');
// 				var original;
// 				var newValue;

// 				sub.on('click', function()
// 				{
// 					original = parseFloat(qty.find('.product_num').text());
// 					if(original > 0)
// 						{
// 							newValue = original - 1;
// 						}
// 					num.text(newValue);
// 				});

// 				add.on('click', function()
// 				{
// 					original = parseFloat(qty.find('.product_num').text());
// 					newValue = original + 1;
// 					num.text(newValue);
// 				});
// 			});
// 		}
// 	}

// });
// var theAddButton = document.getElementById('+');
// var theSubButton = document.getElementById('-');
// var total = document.getElementById('total');
// var price = document.getElementById('price');

// theAddButton.addEventListener('click', function () {
// 	  console.log(price.value);
// 	// console.log(qty.innerHTML);
// 	// console.log(total.innerHTML);
// 	var newTotal = parseFloat(price.innerHTML) * parseFloat(qty.innerHTML);
// 	document.getElementById("total").innerHTML = newTotal;
// 	// total.innerHTML= parseFloat(price.innerHTML) * parseFloat(qty.innerHTML);
// 	// console.log(newValue);
// 	// console.log(typeof(parseFloat(price.innerHTML)*parseFloat(qty.innerHTML)));
// 	console.log(total.innerHTML);
// });
// theSubButton.addEventListener('click', function () {
// 	var newTotal = parseFloat(price.innerHTML) * parseFloat(qty.innerHTML);
// 	document.getElementById("total").innerHTML = newTotal;
// });
let plus=Array.from(document.querySelectorAll('.plus'));
let modelNumber=Array.from(document.querySelectorAll('.model-number'));
let minus=Array.from(document.querySelectorAll('.minus'));
let modelPrice=Array.from(document.querySelectorAll('.model-price'));
let tab=[150,250,100];
let totalPrice=document.querySelector('.total-price');

for(let i=0;i<plus.length;i++)
  {
    plus[i].addEventListener("click",(event)=>{ 
      console.log('hello');
      let valPlus=modelNumber[i].innerHTML;
	  modelNumber[i].innerHTML=parseInt(valPlus)+1;
	  console.log
  modelPrice[i].value=parseInt(modelPrice[i].value)+tab[i]+"$";   
      totalPrice.value=parseInt(totalPrice.value)+tab[i]+"$";
  });
  
     minus[i].addEventListener("click",(event)=>{ 
       let valMinus=parseInt(modelNumber[i].value);
       if(valMinus>0){
          modelNumber[i].value=valMinus-1;
       }
       let valPrice=parseInt(modelPrice[i].value);
       if(valPrice>0){
         modelPrice[i].value=valPrice-tab[i]+"$";
        totalPrice.value=parseInt(totalPrice.value)-tab[i]+"$";

       }
  }); 
};
