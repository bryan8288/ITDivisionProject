<?php  
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Max-Age: 3600");
	header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

	include_once 'C:/xampp/htdocs/api/config/database.php';
	include_once 'C:/xampp/htdocs/api/model/User.php';
	 
	$database = new Database();
	$db = $database->getConnection();
	 
	$user = new User($db);

	$data = json_decode(file_get_contents('php://input'));

	if(
		!empty($data->UserName) &&
		!empty($data->UserEmail) &&
		!empty($data->UserPhone) &&
		!empty($data->UserDOB) &&
		!empty($data->UserPassword)
	){
		$user->UserName = $data->UserName;
		$user->UserEmail = $data->UserEmail;
		$user->UserPhone = $data->UserPhone;
		$user->UserDOB = $data->UserDOB;
		$user->UserPassword = $data->UserPassword;

		$stmt = $user->isExist();
		$row = $stmt->fetch(PDO::FETCH_ASSOC);

		if($row != null){
			echo json_encode(array("Message" => "Username or email already exist!"));
		}
		else{
			$user->register();
		}
	}
?>