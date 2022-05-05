<?php

include("db_info.php");

$genre = $_GET['genre'];

$res = mysqli_query($mysqli, "SELECT * FROM shows WHERE genre = "drama"");
$res[] = $raw;
$json_respnse = json_encode($res);
echo $json_respnse;
exit();