$(document).ready(function() {
	
    $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
          "url": "/starter/pagination",
          "type": "POST"
        },
        "columns": [
          { data: 'namedInsured'},
          { data: 'status'}
        ]
    });
} );

