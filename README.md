# SneakerShip for Android
SneakerShip is a SneakerStore with variety of sneakers. It has features like , adding sneaker to cart , searching sneaker , having details of a sneaker. Sneakership is implemented with MVVM Architecture, Dependency Injection , Data Binding , Navigation Architecture From Jetpack , ListAdapter and DiffUtil.

## Features
## 1. Grid of Top 100 sneakers in home page . 
In the home screen 100 sneakers are shown in the grid with 2 columns. Every grid item has sneaker's Name, Brand and Price . Additionally every sneaker item has add button. Add button adds sneakers into checkout screen, which is basically cart . This feature is similar to add to cart feature of most of the shopping applications.

![home_screen_showing_grid_of_sneakers](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/d9d9caa5-e723-4784-9c96-85724a302613)

## 2. Add to cart for sneaker 
To add Sneaker to cart you have to click to small add button at corner of sneaker . This will create notification badge for item at bottom right corner in bottomNavigation . This shows that item has been added to cart.

![item_added_to_cart](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/0a6d407a-2e59-4f3d-a246-b39215e5c013)![item_added_to_cart_badge](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/55769e47-54dc-41e7-ac14-7536acdaff6a)

## 3. Search Functionality
You can search your favorite sneaker with the help of search view in top bar of home screen. After typing the text in search view sneakers get filtered with respect to given query and results are shown. 

![search_functionality](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/46f2ca50-275a-498b-b22e-cb0134180ff2)
![search_sneakers](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/9448b88c-d2ba-4c32-87e4-be778bc60066)

## 4. Sneaker Detail Screen When Clicked On Sneaker 
When you click on specific sneaker details screen of that sneaker is opened. In the detail screen you can see multiple images of sneaker , name , price of snekaer. You can select different size and color combination for sneaker.  At last you get checkout button through which you can add this sneaker to you cart .

![detail_of_sneaker](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/9dfa9535-b383-42fa-8760-768ce5f7c97f)
![multiple_image_size_color](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/9c60ab88-09c1-4e8b-8bee-ac25f394a97b)

## 5. Checkout Page 
Checkout page is opened by clicking on cart icon at bottom right corner. Checkout page has sneaker which are added from home screen as well as detail screen . It will show list of sneaker . It also has remove from cart button at each item . At the end of page order total is calculated with taxes and other charges . 

![checkout_page](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/6bb7e3be-ee65-41b3-b1ac-b112fbd43b5f)
![checkout_page_item_removed](https://github.com/Atul-Khandekar/SneakerShip/assets/125445267/84724576-081b-40bd-86fc-73d6885c09a6)

## Decisions made while developing SneakerShip

-> SneakerShip purely uses hardcoded data for everywhere in application. Hardcoded data was the current requirement. Still SneakerShip uses MVVM Architecture with Repository pattern . 
Use of MVVM architecture makes SneakerShip Scalable for future requirements. 

-> All the data in recycler views are set using Data Binding Library which is much cleaner way . I have used ListAdapter with DiffUtil because of their efficiency to handle DataSet changes and inbuilt support for animations. Modularization of code is done using Base classes for Adapters and ViewHolders which reduces code redundancy .

-> Dependency Injection is implemented for singleton objects and hassle-free object creation. It can help if we want to implement REST API and ROOM in SneakerShip.

-> In the home screen , search functionality is implemented using ActionViewClass called SearchView.

-> In the detail screen viewPager is used with PagerAdapter. 

## Assumptions made while developing SneakerShip

-> I have used Dependency Injection using HILT ,assuming that infutre we would implement services for REST Apis . It would also benefit us if we would use ROOM Database . 

-> I have used Respository pattern so that infuture data can have single source of truth. Repository can have data from both , services and databases. We can easiily deacuple that through single source of truth. 
