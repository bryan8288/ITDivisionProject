<?php  

class QuizResult
{
	private $conn;
	private $table_name = "TrQuizResult";

	public $ResultID;
	public $BabID;
	public $UserID;
	public $Score;

	public $BabName;
	public $MaPelName;
	
	function __construct($db){
		$this->conn = $db;
	}

	function sendQuizResult()
	{
		$query = "EXEC sp_sendQuizResult '".$this->BabName."', '".$this->MaPelName."', '".$this->UserID."', '".$this->Score."'";

		$stmt = $this->conn->prepare($query);

		if($stmt->execute()){
			return true;
		}

		return false;
	}
}


?>