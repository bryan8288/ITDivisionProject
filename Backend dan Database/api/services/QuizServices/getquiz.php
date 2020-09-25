<?php  
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Max-Age: 3600");
	header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

	include_once 'C:/xampp/htdocs/api/config/database.php';
	include_once 'C:/xampp/htdocs/api/model/Quiz.php';

	$database = new Database();
	$db = $database->getConnection();

	$quiz = new Quiz($db);

	$data = json_decode(file_get_contents('php://input'));

	if(
		!empty($data->BabName) &&
		!empty($data->MaPelName)
	){
		$quiz->BabName = $data->BabName;
		$quiz->MaPelName = $data->MaPelName;

		$stmt = $quiz->getQuiz();

		$Quizarr = array();

		while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
			extract($row);

			$quiz_item = array(
				"QuizID" => $QuizID,
				"SoalQuiz" => $SoalQuiz,
				"WrongAnswer1" => $WrongAnswer1,
				"WrongAnswer2" => $WrongAnswer2,
				"WrongAnswer3" => $WrongAnswer3,
				"CorrectAnswer" => $CorrectAnswer
			);

			array_push($Quizarr, $quiz_item);
		}

    	http_response_code(200);
    	echo json_encode($Quizarr);
	}
?>