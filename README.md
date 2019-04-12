# FYP

FUNCTIONAL

FYP/Wanderlust/app/src/main/AndroidManifest.xml 
	
	Contains permissions, activities, and also any API keys

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/
	
	There are 8 folders for 8 cities - AMS, BER, BRC, DXB, LDN, PRS, ROM, TCY Within each folder there are different 		classes - Accommodation, Attraction, POI, Restaurant and Home Page

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/DatabaseHelper.java
	
	Class which extends SQLiteOpenHelper

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/MainActivity.java

	Page that displays once app is opened. Allows user to login

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/RegisterNow.java

	Allows user to Login/Register

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/MainPage.java

	Activity that holds three fragments: Home, Map, ProfilePage
	>HOME - shows 8 different cities
	>MAP - shows different tourist's preferred attractions through various sizes of circles representing polarity score
	>PROFILEPAGE - shows user's info and itineraries

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/RecyclerViewAdapter.java

	Page which is responsible for the category layout

FYP/Wanderlust/app/src/main/java/com/example/barang/wanderlust/TripMap.java

	Map that displays the itinerary of the user

API CALL

FYP/Data.ipnyb
	
	Contains API Calls to Tour-Pedia using PYTHON
	Grabs relevant attractions 
	Only places with previous reviews are taken
	VADER is implemented here too
	Datafiles contains csv files and json file for Firebase
