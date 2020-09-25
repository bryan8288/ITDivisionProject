<?php  
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Max-Age: 3600");
	header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

	include_once 'C:/xampp/htdocs/api/config/database.php';
	include_once 'C:/xampp/htdocs/api/model/ForumGeneral.php';

	$database = new Database();
	$db = $database->getConnection();

	$forumGeneral = new ForumGeneral($db);

	$data = json_decode(file_get_contents('php://input'));

	if(
		!empty($data->ForumThreadMaker) &&
		!empty($data->ForumDescription) &&
		!empty($data->JurusanName) &&
		!empty($data->MaPelName)
	){
		$forumGeneral->ForumThreadMaker = $data->ForumThreadMaker;
		$forumGeneral->ForumDescription = $data->ForumDescription;
		$forumGeneral->JurusanName = $data->JurusanName;
		$forumGeneral->MaPelName = $data->MaPelName;

		if($forumGeneral->newForumThread()){
			echo json_encode(array("Message" => "Adding new thread success!"));
		}
	}
?>