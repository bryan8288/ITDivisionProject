<?php  

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");

	include_once 'C:/xampp/htdocs/api/config/database.php';
    include_once 'C:/xampp/htdocs/api/model/ForumReply.php';

    $database = new Database();
	$db = $database->getConnection();

	$forumReply = new ForumReply($db);

	$data = json_decode(file_get_contents('php://input'));;

	if(!empty($data->ForumID)){

		$forumReply->ForumID = $data->ForumID;

		$stmt = $forumReply->getForumReply();

		$ForumReplyarr = array();

		while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
			extract($row);

			$forumReply_item = array(
				"ForumReplyID" => $ForumReplyID,
				"ReplyMaker" => $ReplyMaker,
				"ForumReplyDescription" => $ForumReplyDesc,
				"ForumScore" => $ForumScore
			);

			array_push($ForumReplyarr, $forumReply_item);
		}

    	http_response_code(200);
    	echo json_encode($ForumReplyarr);
	}

?>