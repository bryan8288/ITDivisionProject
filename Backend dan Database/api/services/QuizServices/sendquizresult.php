<?php  
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Max-Age: 3600");
	header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

	include_once 'C:/xampp/htdocs/api/config/database.php';
	include_once 'C:/xampp/htdocs/api/model/QuizResult.php';

	$database = new Database();
	$db = $database->getConnection();

	$quizResult = new QuizResult($db);

	$data = json_decode(file_get_contents('php://input'));

	if(
		!empty($data->BabName) &&
		!empty($data->MaPelName) &&
		!empty($data->UserID) &&
		!empty($data->Score) 
	){
		$quizResult->BabName = $data->BabName;
		$quizResult->MaPelName = $data->MaPelName;
		$quizResult->UserID = $data->UserID;
		$quizResult->Score = $data->Score;

		if($quizResult->sendQuizResult()){
			echo json_encode(array("Message" => "Sending Quiz Result success!"));
		}
	}


?>