import { Component, Input, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router,ActivatedRoute } from '@angular/router';
import { bill } from '../model/bill';
import { invoiceInfo } from '../model/invoice';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-pay-bill',
  templateUrl: './pay-bill.component.html',
  styleUrls: ['./pay-bill.component.css']
})
export class PayBillComponent implements OnInit {

  billtopay:any=<bill>{};
  invoiceinfo:any=<invoiceInfo>{};
  selectedPaymentMethod: string = '';

  constructor(private service:HttpService,
    private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getIdFromURL();
  }

  getIdFromURL(){
      
      this.route.paramMap.subscribe((pragma)=>{
        this.service.getSpecificBillData(pragma.get("id")).subscribe((response)=>{
          this.billtopay=response; 
          console.log(this.billtopay.billId)
          this.service.getInvoiceData(this.billtopay.billId).subscribe((response)=>{
            this.invoiceinfo=response;
            console.log(response);
        })
        })  
      })


  }

  onSubmit(form: NgForm){
    
    console.log(form.controls['paymentMethod'].value);
  }

  return(){
    this.router.navigate(['/billDetails']);
  }

  pay(){
    this.service.paybillOnline(this.billtopay).subscribe((response)=>{
      if(response==="Done"){
        this.router.navigate(['/billDetails']);
      }
    })
  }

}
