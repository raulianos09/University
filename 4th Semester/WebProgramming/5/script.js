
$( document ).ready(function() {

    // sort functions
    $('th').click(function(){
        //get data
        var table = $(this).parents('table').eq(0)
        var rows = table.find('tr').slice(1,11).toArray().sort(comparer($(this).index()))

        //check order
        this.asc = !this.asc

        if (!this.asc)
            {rows = rows.reverse()}

        for (var i = 0; i < rows.length; i++)
            {table.append(rows[i])}
    })

    function comparer(index) {
        return function(a,b) {
            var valA = getCellValue(a, index)
            var valB = getCellValue(b, index)
            return  valA.localeCompare(valB)
        }
    }

    function getCellValue(row, index){ return $(row).children('td').eq(index).html() }


    //change rows functions
    $('tfoot tr').click(
        function(e){
            var index=e.toElement.cellIndex;
            moveColumn($('table'), index,index+1);
        });

    function moveColumn(table, index, index2) {
        var cols;
        $('tr', table).each(
            function () {
                cols = $(this).children('th, td');

                if(index!==3){
                    cols.eq(index).insertBefore(cols.eq(index2));
                    cols.eq(index2).insertBefore(cols.eq(index));
                }
                else
                    {
                    cols.eq(0).detach().insertBefore(cols.eq(3));
                    cols.eq(3).detach().insertBefore(cols.eq(1));
                    }
            });
    }


});