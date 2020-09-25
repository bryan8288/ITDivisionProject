<?php  

class Quiz
{
	private $conn;
	private $table_name = "TrQuiz";

	public $QuizID;
	public $SoalQuiz;
	public $WrongAnswer1;
	public $WrongAnswer2;
	public $WrongAnswer3;
	public $CorrectAnswer;

	public $BabName;
	public $MaPelName;
	
	function __construct($db)
	{
		$this->conn = $db;
	}

	public function getQuiz(){
		$query = "EXEC sp_getQuiz '".$this->BabName."', '".$this->MaPelName."'";

		$stmt = $this->conn->prepare($query);
	    $stmt->execute();

	    return $stmt;
	}

}


?>