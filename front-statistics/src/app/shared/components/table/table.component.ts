import { Component, OnInit, Input, ViewChild, EventEmitter, Output, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { Observable, from } from 'rxjs';
import { DatatableComponent, DataTableFooterComponent, DataTablePagerComponent } from '@swimlane/ngx-datatable';
import { TableColumn, ColumnMode } from '@swimlane/ngx-datatable';
import { FormBuilder } from '@angular/forms';
import { DataInteraction } from 'src/app/core/models/dataInteration';
import { ViewEncapsulation } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { DataService } from 'src/app/core/services/data.service';
import { Page } from 'src/app/core/models/Page';



@Component({
  selector: "app-table",
  templateUrl: "./table.component.html",
  styleUrls: ["./table.component.scss"],
  encapsulation: ViewEncapsulation.None,
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TableComponent implements OnInit {
  @ViewChild(DatatableComponent, { static: true }) table: DatatableComponent;

  @Input() filtro$: Observable<Paginate>;
  @Input() data$: Observable<any[]>;
  @Input() dataWeek$: Observable<any[]>;
  @Input() dataClients$: Observable<any[]>;
  @Input() dataBManagers$: Observable<any[]>;
  @Input() dataInteractions$: Observable<any[]>;
  @Input() dataUnities$: Observable<any[]>;
  @Input() dataPagination$: Observable<Paginate>;
  @Input() revenueClient$: Observable<any[]>;
  @Input() revenueManager$: Observable<any[]>;
  @Input() filterClient$: Observable<any[]>;
  @Input() filterManager$: Observable<any[]>;


  ColumnMode = ColumnMode;
  temp = [];
  rows = [];
  inputSearch = '';
  selectInteraction: string;
  selectBM: string;
  selectClient: string;
  selectUnit: string;
  selectWeek: string;
  client: string;
  manager:string;
  apiUrl = 'http://127.0.0.1:8080/kpiManager/api/';
  page = new Page();
  totalElements = 0;
  pageInfo = {
    offset: 0,
    limit: 10,
    count: 0,
  };

  arr = [];
  array = [];
  arrayManager = [];
  taxaClient;
  aux3 = [];
  aux4 = [];



  ngOnInit() {
    this.filterClient();
    this.filterManager() ;
    console.log('ngOnInit - start');
    this.selectInteraction = !!window.history.state.selectInteraction ? window.history.state.selectInteraction : '';
    this.selectBM = !!window.history.state.selectBM ? window.history.state.selectBM : '';
    this.selectClient = !!window.history.state.selectClient ? window.history.state.selectClient : '';
    this.selectUnit = !!window.history.state.selectUnit ? window.history.state.selectUnit : '';
    this.selectWeek = !!window.history.state.selectWeek ? window.history.state.selectWeek : '';
    this.setPage({ offset: 0, limit: 10, count: 0 });
    this.fetch(data => {
      this.temp = [...data]
    });
    this.revenueClient$.subscribe(res => {
      this.arr = [...res];
      console.log("revenueClient$:", this.arr);

    });
    console.log('ngOnInit - fim');

  }


  constructor(
    private http: HttpClient,
    private cdr: ChangeDetectorRef
  ) {
    this.page.pageNumber = 0;
    this.page.size = 10;
  }


 


  refreshTable() {
    this.filterClearSelect();
    this.inputSearch = '';
    this.filter(true);
  }

  fetch(cb) {
    const req = new XMLHttpRequest();
    req.open("GET", "  http://127.0.0.1:8080/kpiManager/api/interactions/all");
    req.onload = () => {
      cb(JSON.parse(req.response));
    };
    req.send();
    console.log('passou req', req);
  }

  updateFilter(event) {
    this.filterClearSelect();
    const val = event.target.value.toLowerCase();
    const temp = this.temp.filter(function (d) {
      return (
        d.person.name.toLowerCase().indexOf(val) !== -1 ||
        d.client.name.toLowerCase().indexOf(val) !== -1 ||
        d.unit.nameUnit.toLowerCase().indexOf(val) !== -1 ||
        d.dateInteraction.toLowerCase().indexOf(val) !== -1 ||
        d.interactionType.interactionType.toLowerCase().indexOf(val) !== -1 ||
        !val
      );
    });
    this.rows = temp;
    this.table.offset = 0;
    this.totalElements = temp.length;
    console.log('passou', this.rows);
  }

  filterClient() {
    this.filterClient$ = this.http.get<any[]>(this.apiUrl + 'interactions/filter/client');
    this.filterClient$.subscribe((res) => {
      this.array = [...res];
      console.log("array clientes", this.array);
      //this.table.offset = 0;
      this.cdr.detectChanges();
      this.conversionArray('client');
    });
  }



  filterManager() {
    this.filterManager$ = this.http.get<any[]>(this.apiUrl + 'interactions/filter/manager');
    this.filterManager$.subscribe((res) => {
      this.arrayManager = [...res];
      console.log("array manager", this.arrayManager);
      //this.table.offset = 0;
      this.cdr.detectChanges();
      this.conversionArray('businessManager');
    });
  }



  filter(isFilter) {
    console.log(isFilter);
    if (isFilter) {// se for filtro tem de mudar para a primeira pagina se for paginaçao nao
      this.table.offset = 0;
      this.pageInfo.offset = 0;
    }
    console.log(this.pageInfo);
    //this.rows = [];
    let myselectWeek, myselectUnit, myselectClient, myselectBM, myselectInteration, startIndex;
    myselectBM = this.selectBM !== '' ? this.selectBM : null;
    myselectClient = this.selectClient !== '' ? this.selectClient : null;
    myselectUnit = this.selectUnit !== '' ? this.selectUnit : null;
    myselectWeek = this.selectWeek !== '' ? this.selectWeek : null;
    myselectInteration = this.selectInteraction !== '' ? this.selectInteraction : null;
    let params = new HttpParams();
    startIndex = this.pageInfo.offset * this.pageInfo.limit;
    params = params.append('week', myselectWeek);
    params = params.append('unit', myselectUnit);
    params = params.append('client', myselectClient);
    params = params.append('businessManagers', myselectBM);
    params = params.append('interaction', myselectInteration);
    params = params.append('startIndex', startIndex.toString());
    params = params.append('quantity', this.pageInfo.limit.toString());

    this.filtro$ = this.http.get<Paginate>(this.apiUrl + 'interactions/filter', {
      params
    });
    this.filtro$.subscribe((res: Paginate) => {
      this.rows = [...res.elements]
      // this.rows = this.temp;
      console.log(this.rows);
      this.totalElements = res.totalElements;
      //this.table.offset = 0;
      this.cdr.detectChanges();
    });
  }

  filterClearSelect() {
    this.selectBM = '';
    this.selectClient = '';
    this.selectWeek = '';
    this.selectUnit = '';
    this.selectInteraction = '';
    // fazer o clear da paginacao para voltar à posicao 0 (pagina 1)
  }

  setPage(pageInfo: { count: number, limit: number, offset: number }) {

    this.pageInfo = pageInfo;
    console.log('pageInfo', pageInfo);

    this.filter(false);
    /* if (this.selectInteraction !== '' || this.selectUnit !== '' || this.selectUnit !== '' || this.selectWeek !== '' || this.selectClient) {
      this.filter();
    } else {
      this.fetch(data => {
        this.totalElements = data.length;
        //this.rows = [];
        let myselectWeek, myselectUnit, myselectClient, myselectBM, myselectInteration;
        myselectBM = this.selectBM !== '' ? this.selectBM : null;
        myselectClient = this.selectClient !== '' ? this.selectClient : null;
        myselectUnit = this.selectUnit !== '' ? this.selectUnit : null;
        myselectWeek = this.selectWeek !== '' ? this.selectWeek : null;
        myselectInteration = this.selectInteraction !== '' ? this.selectInteraction : null;

        let params = new HttpParams();
        console.log('offsetpageNumber = ', this.pageInfo.offset, 'pageSize = ', pageInfo.limit, 'count = ', pageInfo.count);

        params = params.append('week', myselectWeek);
        params = params.append('unit', myselectUnit);
        params = params.append('client', myselectClient);
        params = params.append('businessManagers', myselectBM);
        params = params.append('interaction', myselectInteration);
        params = params.append('startIndex', this.pageInfo.offset.toString());
        params = params.append('quantity', this.pageInfo.limit.toString());

        this.dataPagination$ = this.http.get<Paginate>(this.apiUrl + 'interactions/filter', { params });

        this.dataPagination$.subscribe((res: Paginate) => {
          console.log('dataPagination = ', res);
          this.temp = [...res.elements];
          this.rows = this.temp;
          console.log('rows aqui =', this.rows);
          this.table.offset = 0;
          this.page.size = pageInfo.limit;
          this.totalElements = res.totalElements;
          this.page.pageNumber = pageInfo.offset;
          this.cdr.detectChanges();
        });
      });
    } */


  }

  conversionArray(varType) {
    const aux = [];
    const aux2 = [];
    if (varType == "client") {
      this.array.map(elem => {
        console.log(elem)
        const prop = elem[2] == 'Proposta aceite' ? 'accepted' : 'rejected';
        const obj = { [varType]: elem[1]};
        obj[prop] = elem[0];
        aux.push(obj)
      })
    } else {
      this.arrayManager.map(elem => {
        console.log(elem)
        const prop = elem[2] == 'Proposta aceite' ? 'accepted' : 'rejected';
        const obj = { [varType]: elem[1]};
        obj[prop] = elem[0];
        aux.push(obj)
      })
    }

    console.log(aux);
    aux.forEach(elem => {
      const index = aux2.findIndex(i=>i[varType]==elem[varType]);
      if(index != -1) {
        aux2[index] = {...aux2[index], ...elem};
        aux2[index].conversion = Math.round((aux2[index].accepted / (aux2[index].accepted + aux2[index].rejected) * 100));
      } else {
        aux2.push(elem);
      }
    })
    aux2.forEach(elem => {
      const conversion = elem.rejected == undefined ? 100 : elem.accepted == undefined ? 0 : elem.conversion;
      if(elem.rejected == undefined) {
        elem.rejected = " 0 ";
      }
      if(elem.accepted == undefined)
        elem.accepted = " 0 ";

      if (varType == "client") {
        this.aux3.push({...elem, conversion: conversion});
      } else {
        this.aux4.push({...elem, conversion: conversion});
      }
    })
  }
 
  col = ["Business Manager", "Accepted Contracts", "Rejected Contracts", "Success Rate"];
  sort(colName) {
    console.log("propCol = ",colName);
    if(colName == "Business Manager"){
      colName = "businessManager";
    }
    if(colName == "Accepted Contracts"){
      colName = "accepted";
    }
    if(colName == "Rejected Contracts"){
      colName = "rejected";
    }
    if(colName == "Success Rate"){
      colName = "conversion";
    }
    

    this.aux4.sort((a, b) => a[colName] > b[colName] ? 1 : a[colName] < b[colName] ? -1 : 0)
    console.log("aux4Sorted = ",this.aux4);
    
}
}


export interface Paginate {

  elements: Object[];
  totalElements: number;

}




