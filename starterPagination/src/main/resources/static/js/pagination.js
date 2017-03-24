$(document).ready(function() {
	
	$.fn.dataTable.ext.errMode = 'none';
	
    var table = $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "searching":   false,
        "ajax": {
          "url": "/starter/pagination",
          "type": "POST",
          
          "data": function (d) {
            return $.extend( {}, d, {
              "searchFilter.statusId": $('#status option:selected').val(),
              "searchFilter.startDate": $('#startDate').val(),
              "searchFilter.endDate": $('#endDate').val(),
              "search": $('#mySearch').val()
            });
          },
          "dataSrc": function ( json ) {
              // alert('you again');  // override this to see what results are in json, i will want to use jsonFormResponse and see how it goes, https://datatables.net/reference/option/ajax.dataSrc
              return json.data;
            }
        },
        "columns": [
          { data: 'namedInsured'},
          { data: 'status'},
          { data: 'createdDateString'}
        ]
    }).on( 'error.dt', function (e, settings, techNote, message ) { // triggered when response is NOT of 2XX
    	alert(message);
        //console.log( 'An error has been reported by DataTables: ', message );
    } );
    
    $('#btn').on('click', function() {
      table.draw();
    });
} );

