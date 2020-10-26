import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'credit-card-web';

  text = 'jeff';

  results: string[];

  cards = [];

  recCards = [];

  cols: any[];

  recCols: any[];

  weights: any;


  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    this.cols = [
      { field: 'cardName', header: '產品名稱' },
      { field: 'issuer', header: '發卡銀行' },
      { field: 'bankCardAssociation', header: '國際信用卡組織' },
      { field: 'domesticRewardPoint', header: '海外現金回饋' },
      { field: 'foreignRewardPoint', header: '海外現金回饋' },
      { field: 'otherDiscounts', header: '其他優惠' },
      { field: 'annualFee', header: '年費' }
    ];

    this.recCols = [
      { field: 'cardName', header: '產品名稱' },
      { field: 'issuer', header: '發卡銀行' },
      { field: 'bankCardAssociation', header: '國際信用卡組織' },
      { field: 'domesticRewardPointSocre', header: '國內現金回饋評分' },
      { field: 'foreignRewardPointScore', header: '海外現金回饋評分' },
      { field: 'annualFeeScore', header: '年費評分' },
      { field: 'otherDiscountsScore', header: '其他優惠評分' },
      { field: 'totalScore', header: '推薦總分' }
    ];

    this.refreashData();

    setInterval(() => {
      this.refreashData();
    }, 10000);
  }

  refreashData() {

    console.log('fetch data for user:', this.text);
    // tslint:disable-next-line: max-line-length
    const creditCardUrl = 'http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/api/credit-card';
    // tslint:disable-next-line: max-line-length
    const recommendationHost = 'recommendation-' + this.text + '.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud';
    console.log(recommendationHost);
    const weightUrl = 'http://' + recommendationHost + '/api/weight';
    const recommandationUrl = 'http://' + recommendationHost + '/api/recommendation';

    this.http.get(weightUrl).subscribe((response: any) => {
      this.weights = response;
      this.recCols[3].header = '國內現金回饋評分' + response.domesticRewardPointWeight * 100 + '%';
      this.recCols[4].header = '海外現金回饋評分' + response.foreignRewardPointWeight * 100 + '%';
      this.recCols[5].header = '年費評分' + response.annualFeeWeight * 100 + '%';
      this.recCols[6].header = '其他優惠評分' + response.otherDiscountsWeight * 100 + '%';
      console.log(response);
    });

    this.http.get(creditCardUrl).subscribe((response: any) => {
      this.cards = response.data;
    });

    this.recCards = [];
    this.http.get(recommandationUrl).subscribe((response: any) => {
      console.log(response.data);
      this.recCards = response.data;
    });
  }



  search(event: any) {
    const studentArr = [
      'jeff',
      '105205102',
      '105209028',
      '106306003',
      '106306006',
      '106306008',
      '106306023',
      '106306032',
      '106306033',
      '106306036',
      '106306044',
      '106306053',
      '106306063',
      '106306065',
      '106306067',
      '106306075',
      '106306086',
      '108356005',
      '108356017',
      '108356019',
      '108356021',
      '108356026',
      '108356028',
      '108356030',
      '108356039',
      '108363064',
      '109356002',
      '109356008',
      '109356012',
      '109356027',
      '109356030',
      '109356031',
      '109356033',
      '109356039'];
    this.results = studentArr.filter(item => item.includes(event.query));
  }

  handleDropdown(event: string) {
    console.log(event);
    this.text = event;
    this.refreashData();
  }

}
