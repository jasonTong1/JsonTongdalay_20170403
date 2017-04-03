/**
	根据数组对象中的某一个字段 给它排序
*/

'use strict';
function sort() {
	//需要排成的顺序
    var order = ['cai','tong', 'qing', 'yue'];
    //现有的对象数组
    var objs = [
        { id: 'aa', name: 'aa' },
        { id: 'bb', name: 'dd' },
        { id: 'yue', name: 'aa' },
        { id: 'cai', name: 'bb' },
        { id: 'cc', name: 'dd' },
        { id: 'qing', name: 'cc' },
        { id: 'tong', name: 'dd' },
        { id: 'dd', name: 'dd' }
    ];
document.write(JSON.stringify(objs));
document.write('</br></br>');
	//遍历顺序规则的数组 遍历原对象数组 
	//如果包含的字段有相等 依次插入一个到前面 再将原有的删除掉只保留一个
    for (var orderIndex = 0,insertIndex=0; orderIndex < order.length; orderIndex++) {
        for (var cfgindex=insertIndex;cfgindex<objs.length;cfgindex++) {
        	if(order[orderIndex]===objs[cfgindex].id){
        		objs.splice(insertIndex,0,objs[cfgindex]);
        		objs.splice(cfgindex+1,1);
        		insertIndex++;
        		break;
        	}
        }
    }
document.write(JSON.stringify(objs));
}

sort();
