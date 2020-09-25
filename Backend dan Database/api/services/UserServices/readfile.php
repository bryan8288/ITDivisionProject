<?php  

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");

	include_once 'C:/xampp/htdocs/api/config/database.php';
    include_once 'C:/xampp/htdocs/api/model/User.php';
	 
	$database = new Database();
	$db = $database->getConnection();
	 
	$user = new User($db);

	$stmt = $user->read();

	$users_arr = array();
 
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        extract($row);
 
        $user_item = array(
            "UserID" => $UserID,
            "UserName" => $UserName,
            "UserEmail" => $UserEmail,
            "UserPhone" => $UserPhone,
            "UserDOB" => $UserDOB,
            "UserPassword" => $UserPassword
        );
 
        array_push($users_arr, $user_item);
    }
 
    http_response_code(200); 
    echo json_encode($users_arr);
	
?>