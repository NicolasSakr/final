<?php

include("db_info.php");

$over = $_GET['overview'];
$casting = $_GET['cast'];
$rating = $_GET['rating'];


$res = mysqli_query($mysqli, "SELECT * FROM shows WHERE show_name = "Dexter"");
$res[] = $raw;
$json_respnse = json_encode($res);
echo $json_respnse;
exit();