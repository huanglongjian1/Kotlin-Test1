package com.android.kotlin_test1.test5.bean;

import java.util.List;

public class Test5Bean {

    /**
     * results : [{"gender":"female","name":{"title":"Mrs","first":"Ayida","last":"Andrusyak"},"location":{"street":{"number":1572,"name":"Kolodyazna"},"city":"Zavodske","state":"Harkivska","country":"Ukraine","postcode":24496,"coordinates":{"latitude":"79.2701","longitude":"107.9680"},"timezone":{"offset":"-1:00","description":"Azores, Cape Verde Islands"}},"email":"ayida.andrusyak@example.com","login":{"uuid":"0096265c-2da2-4882-af44-ef66b2576142","username":"crazytiger996","password":"cowboys","salt":"YNkHGiO7","md5":"867e4e1ffcac15ba1bfbd118e276f7ab","sha1":"eb648f23d2d62499f70fbda5f17c24bdf96efe76","sha256":"269ce16e8efc30411c0d66e6d8ed6cce3c07c6925c3c3d01d46306f3c9d99c08"},"dob":{"date":"1968-08-25T08:26:24.355Z","age":55},"registered":{"date":"2010-11-24T22:50:21.835Z","age":12},"phone":"(067) I44-0216","cell":"(097) E63-1806","id":{"name":"","value":null},"picture":{"large":"https://randomuser.me/api/portraits/women/72.jpg","medium":"https://randomuser.me/api/portraits/med/women/72.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/72.jpg"},"nat":"UA"}]
     * info : {"seed":"190972f748bfcf42","results":1,"page":1,"version":"1.4"}
     */

    private InfoBean info;
    private List<ResultsBean> results;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }
}
