<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script type="text/javascript" src="../../js/swfupload/swfupload.js"></script>
	<!--  <script type="text/javascript" src="../../js/swfupload/swfupload.queue.js"></script> -->
	<script type="text/javascript" src="../../js/swfupload/handlers.js"></script>

	<script type="text/javascript">

		var Uploader = {
			fileQueued: function(file) {
				upload.startUpload();
			},
			
			uploadComplete: function(file) {
			},
			
			uploadStart: function(file) {
			},
			
			uploadProgress: function(file, bytesLoaded, bytesTotal) {
				var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);
				$('#uploadPorcessBar').text('Upload File Finished: '+percent+'%');
			},
			
			uploadSuccess: function(file, serverData) {
				var data = eval("("+serverData+")");
				if (data.code == -1) {
					alert(data.text);
					return;
				}
				$('#uploadTipsBlock').html('<img src="'+data.image+'" style="width:191px;height:143px;" />');
				$('#uploadImageUrl').val(data.image);
			},
			
			fileQueueError: function(file, errorCode, message) {
				console.log(file);
				console.log(errorCode);
				console.log(message);
			}
		};

		var swfu;
		window.onload = function () {
			swfu = new SWFUpload({
				upload_url: "/upload",
				post_params: {"name" : "zwm"},
				use_query_string:true,
				// File Upload Settings
				file_size_limit : "10 MB",	// 文件大小控制
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : "0",
								
				//file_queue_error_handler : fileQueueError,
				//file_dialog_complete_handler : fileDialogComplete,//选择好文件后提交
				//file_queued_handler : fileQueued,
				//upload_progress_handler : uploadProgress,
				//upload_error_handler : uploadError,
				//upload_success_handler : uploadSuccess,
				//upload_complete_handler : uploadComplete,

				// button 
				button_placeholder_id : "uploadImageButtomx",
				button_image_url: "../js/swfupload/images/UploadButton.png",
				button_width : 99,
				button_height : 25,
				button_text : "<b>添加文件</b>",
				button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
				button_text_left_padding : 3,
				button_text_top_padding : 2,
				button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
				button_cursor : SWFUpload.CURSOR.HAND,

				//handler
				file_queued_handler : Uploader.fileQueued,
				file_queue_error_handler : Uploader.fileQueueError,
				upload_complete_handler : Uploader.uploadComplete,
				upload_start_handler : Uploader.uploadStart,
				upload_progress_handler : Uploader.uploadProgress,
				upload_success_handler : Uploader.uploadSuccess

				
				// Flash Settings
				flash_url : "../../js/swfupload/swfupload.swf",

				custom_settings : {
					upload_target : "divFileProgressContainer"
				},
				// Debug Settings
				debug: false  //是否显示调试窗口
			});
		};
		function startUploadFile(){
			swfu.startUpload();
		}
		
	</script>
</head>
<body>
	<div id="content">
		<form>
			<div>
				<span id="uploadImageButtomx"></span>
				<input id="btnUpload" type="button" value="上  传" onclick="startUploadFile();" class="btn3_mouseout"  />
				<input id="btnCancel" type="button" value="取消所有上传" onclick="cancelUpload();" disabled="disabled"  />
			</div>
		</form>
		<div id="divFileProgressContainer"></div>
		<div id="thumbnails">
			<table id="infoTable" ></table>
		</div>
	</div>	
</body>
</html>


