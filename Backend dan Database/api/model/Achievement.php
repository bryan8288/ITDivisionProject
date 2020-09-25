<?php  

class Achievement
{
	private $conn;
	private $table_name = "TrAchievement";

	public $UserName;
	public $AchievementName;
	public $Score;

	function __construct($db)
	{
		$this->conn = $db;
	}

	function getAchievement(){
		$query = "EXEC sp_getAchievement";

		$stmt = $this->conn->prepare($query);
		$stmt->execute();

		return $stmt;
	}
}

?>