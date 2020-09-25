<?php  

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");

	include_once 'C:/xampp/htdocs/api/config/database.php';
    include_once 'C:/xampp/htdocs/api/model/ForumGeneral.php';

    $database = new Database();
	$db = $database->getConnection();

	$forumGeneral = new ForumGeneral($db);
	$stmt = $forumGeneral->getForumThread();

	$ForumGeneralarr = array();

	while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
		extract($row);

		$forumGeneral_item = array(
			"ForumID" => $ForumID,
			"ForumThreadMaker" => $ForumThreadMaker,
			"ForumDescription" => $ForumDescription,
		);

		array_push($ForumGeneralarr, $forumGeneral_item);
	}

    http_response_code(200);
    echo json_encode($ForumGeneralarr);
?>