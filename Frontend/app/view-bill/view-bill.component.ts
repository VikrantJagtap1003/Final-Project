import { Component, OnInit } from '@angular/core';
import { bill } from '../model/bill';
import { invoiceInfo } from '../model/invoice';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-view-bill',
  templateUrl: './view-bill.component.html',
  styleUrls: ['./view-bill.component.css']
})
export class ViewBillComponent implements OnInit {

  billtopay:any=<bill>{};
  invoiceinfo:any=<invoiceInfo>{};
  constructor(private service:HttpService,
    private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getIdFromURL();
  }

  getIdFromURL(){
      
    this.route.paramMap.subscribe((pragma)=>{
      this.service.getSpecificBillData(pragma.get("id")).subscribe((response)=>{
        this.billtopay=response; 
        this.service.getInvoiceData(this.billtopay.billId).subscribe((response)=>{
          this.invoiceinfo=response;
          console.log(response);
      })
      })  
    })

}
goBack(){
  this.router.navigate(['/billDetails']);
}

}
