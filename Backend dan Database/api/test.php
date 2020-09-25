<?php 

	//localhost
	$servername = "LAPTOP-6BAQTN69\SQLEXPRESS";

	try{
		$conn =  new PDO("sqlsrv:Server=$servername;Database=StugerDB", "", "");
		$conn->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
	}
	catch(Exception $e){
		die( print_r( $e->getMessage() ) );
	}

	try  
	{  
		$params = null;
		if(isset($_GET['query'])) {
			$params = array($_GET['query']);  
		}

		$tsql = "SELECT * FROM MsUser";  
		  
		$getUsers = $conn->prepare($tsql);  
		$getUsers->execute($params);  
		$users = $getUsers->fetchAll(PDO::FETCH_ASSOC);  

		$myJson = json_encode($users);
		echo $myJson;
	}  
	catch(Exception $e)  
	{   
		die( print_r( $e->getMessage() ) );   
	} 

?>