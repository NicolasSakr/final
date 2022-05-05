<?php

include("db_info.php");

$fname = $data->first_name;
$lname = $data -> last_name;
$email = $data -> email;
$pass = $data -> password;
$hashed = password_hash($pass, PASSWORD_BCRYPT);

$query = $mysqli->prepare("INSERT INTO users (first_name, last_name, email, password) VALUES (?,?,?,?) )");
$query->bindParam("ssss", $fname, $lname, $email, $hashed);
$query->execute();

$res["status"] = "Worked";
$json_respnse = json_encode($res);
echo $json_respnse;
exit();