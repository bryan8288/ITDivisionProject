<?php  

	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");

	include_once 'C:/xampp/htdocs/api/config/database.php';
    include_once 'C:/xampp/htdocs/api/model/Achievement.php';

	$database = new Database();
	$db = $database->getConnection();
	 
	$achievement = new Achievement($db);

	$stmt = $achievement->getAchievement();

	$achievement_arr = array();
 
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        extract($row);
 
        $achievement_item = array(
            "UserName" => $UserName,
            "AchievementName" => $AchievementName,
            "Score" => $Score
        );
 
        array_push($achievement_arr, $achievement_item);
    }
 
    http_response_code(200); 
    print_r(json_encode($achievement_arr));

?>