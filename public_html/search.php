<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<meta name="description" content="Beetle Word Phrase Checker" />
		<meta name="keywords" content="Beetle online word words phrase phrases spelling checker" />
		<title>Beetle Word-hrase Checker</title>
	</head>
	<body>
		<center>
		<br><br>
		<a href="index.html"><img src='images/logo.jpg'></a>
		<br>
		<h1>Beetle Word-Phrase Checker</h1>
		<table>
			<tr>
				<td>
					<!--<h2>
					<br>
					Checking <?php	echo htmlspecialchars($_POST['input']);?>
					</h2>
					-->
					<?php
						$input = htmlspecialchars($_POST['input']);
						$input = strtolower($input);
						while(strlen($input)>0 && $input[0] == ' '){
							$input = substr($input, 1);
						}
						if(strlen($input) <= 0){
							?>
								<h2>
									<br>
									Oops! You forgot to type something.
								</h2>
							<?php
						}else if(($input[0]<'a' || $input[0] > 'z') && 
								 ($input[0]<'A' || $input[0] > 'Z')){
							?>
								<h2>
									<br>
									Oops! You should not start with <?php echo $input[0] ?>
								</h2>
							<?php	
						}
						else{
							$fp = fopen("data/WordMapDir/".((string)$input[0])."/WordMap", "r") or die("Couldn't open file"); 
							$data = fread($fp, filesize($fp)); 
							$lastWord = NULL;
							while(!feof($fp)) 
							{ 
								$data = fgets($fp, 1024); 
								$values = explode(" ", $data); 
								//values[0] is the word, and values[1] is its count
								if(strcmp($input, $values[0]) < 0){
									//arrived at the place, show two words
									?>
										<h2>
											<br>
											<?php echo $input;?> is not found in Beetle's database, however
										</h2>
									<?php
									if($lastWord != NULL){
										?>
											<h2>
												<br>
												<?php echo $lastWord;?> occurs <?php echo $lastCount;?> times
											</h2>
										<?php
									}
									?>
										<h2>
											<br>
											<?php echo $values[0];?> occurs <?php echo $values[1];?> times
										</h2>
									<?php
									break;
								}else if(strcmp($input, $values[0]) == 0){
									//show only one word
									
									?>
										<h2>
											<br>
											<?php echo $input;?> occurs <?php echo $values[1];?> times in our database
										</h2>
									<?php
									break;
								}
								if(feof($fp)){
									?>
										<h2>
											<br>
											<?php echo $input;?> is not found in Beetle's database, however
										</h2>
									<?php
									if($lastWord != NULL){
										?>
											<h2>
												<br>
												<?php echo $lastWord;?> occurs <?php echo $lastCount;?> times
											</h2>
										<?php
									}
								}
								$lastWord = $values[0];
								$lastCount = $values[1];
							} 
							fclose($fp);
						}
					?>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<div id = "adsense">
			<!--ads-->
			<!--ad 1-->
			<script type="text/javascript"><!--
			google_ad_client = "pub-9930983041493939";
			/* 728x90, created 10/24/08, eecs, ad1 */
			google_ad_slot = "2026855216";
			google_ad_width = 728;
			google_ad_height = 90;
			//-->
			</script>
			<script type="text/javascript"
			src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
			</script>
		</div>
		</center>
		<!-- Google analytics-->
		<script type="text/javascript">
			var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
			document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script type="text/javascript">
			var pageTracker = _gat._getTracker("UA-3023412-4");
			pageTracker._trackPageview();
		</script>
	</body>
</html>