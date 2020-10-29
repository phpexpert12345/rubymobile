package com.pet.rubymobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.deposit.deposit_into_the_wallet.DepositInToTheWalletFragment;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.drawer_paybills.paybills.PaybillsFragment;
import com.pet.rubymobile.drawer_wallet.MyWallet;
import com.pet.rubymobile.pay_and_scan.payCode.PayCodeFragment;
import com.pet.rubymobile.receiveMoney.allService.AllServiceReceiveMoneyFragment;
import com.pet.rubymobile.search.searchFirst.SearchFragment;
import com.pet.rubymobile.setting.allServices.AllServiceSettingFragment;
import com.pet.rubymobile.withdraw.withdraw.WithdrawFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrawerAdapater extends RecyclerView.Adapter<DrawerAdapater.HomeProfile> {
    HomeActivity homeActivity;
    Context context;
    boolean flagOne = false;
    DrawerItemAdapater drawerItemAdapater;

    List flagOpenClose;
    List itemTitleName;

    List itemSubCategory;
    List itemSubMoneyTransfer;
    List itemWallet;
    List itemEcom;
    List itemHotelBooking;
    List itemGiftCard;
    List itemMySetting;
    List itemManageGroupFriends;
    List itemTrasactionHistory;
    List itemLoyalityPoints;
    List itemAgents;
    List itemCreditFacility;
    List itemOtherFeatures;

    public DrawerAdapater(Context context, HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
        this.context = context;
        flagOpenClose = new ArrayList();
        itemTitleName = new ArrayList();

        itemTitleName.add("Paybills");
        itemTitleName.add("Money Transfer/Receive");
        itemTitleName.add("Wallet");
        itemTitleName.add("Hotel Booking");
        itemTitleName.add("E-Commerce");
        itemTitleName.add("Gift Card");
        itemTitleName.add("My Setting");
        itemTitleName.add("Manage Group Friends");
        itemTitleName.add("Transaction History");
        itemTitleName.add("Loyality Points");
        itemTitleName.add("Agents");
        itemTitleName.add("Credit Facilities");
        itemTitleName.add("Other Application Features");


        for (int i = 0; i < itemTitleName.size(); i++) {
            flagOpenClose.add(false);

        }
        itemSubCategory = new ArrayList();
        itemSubCategory.add("Home");
        itemSubCategory.add("Send");
        itemSubCategory.add("Savings");
        itemSubCategory.add("Statements");
        itemSubCategory.add("My Accounts");


        itemSubMoneyTransfer = new ArrayList();
        itemSubMoneyTransfer.add("Add Beneficery");
        itemSubMoneyTransfer.add("Mange Beneficery");
        itemSubMoneyTransfer.add("Fund Transfer");
        itemSubMoneyTransfer.add("Bulk Fund Transfer");
        itemSubMoneyTransfer.add("Wallet");
        itemSubMoneyTransfer.add("Wallet to Account");
        itemSubMoneyTransfer.add("Bank to Bank");
        itemSubMoneyTransfer.add("Withdrawral");
        itemSubMoneyTransfer.add("Scan QR");
        itemSubMoneyTransfer.add("Recieve");
        itemSubMoneyTransfer.add("Request Money");
        itemSubMoneyTransfer.add("Transaction Money");
        itemSubMoneyTransfer.add("View Report");
        itemSubMoneyTransfer.add("Download Transaction History");

        itemWallet = new ArrayList();
        itemWallet.add("Add Money");
        itemWallet.add("Wallet to Wallet transfer");
        itemWallet.add("Wallet to Account");
        itemWallet.add("QR based Wallet");
        itemWallet.add("Qr Payment");
        itemWallet.add("Transcation History");
        itemWallet.add("Download Transaction History");
        itemWallet.add("View Analytics Report");


        itemEcom = new ArrayList();
        itemEcom.add("E-commerce Home Screen");
        itemEcom.add("Filter");
        itemEcom.add("Category");
        itemEcom.add("Product Listing");
        itemEcom.add("Product details");
        itemEcom.add("Shopping cart");
        itemEcom.add("Add/Edit Address");
        itemEcom.add("Payment");
        itemEcom.add("OTP for Payment");
        itemEcom.add("Order Details");
        itemEcom.add("Track Order");
        itemEcom.add("My Order");
        itemEcom.add("Purchase Oder");

        itemHotelBooking = new ArrayList();
        itemHotelBooking.add("Hotel Booking Screen");
        itemHotelBooking.add("Filter");
        itemHotelBooking.add("Hotel Details");
        itemHotelBooking.add("Book Room");
        itemHotelBooking.add("Payment");
        itemHotelBooking.add("Payment");
        itemHotelBooking.add("OTP for Payment");
        itemHotelBooking.add("My Bookings");
        itemHotelBooking.add("Booking Analytics Reports");

        itemGiftCard = new ArrayList();
        itemGiftCard.add("Gift Screen");
        itemGiftCard.add("Gift Voucher");
        itemGiftCard.add("Buy Gift Voucher");
        itemGiftCard.add("Checkout");
        itemGiftCard.add("OTP for Payment");
        itemGiftCard.add("Verification");
        itemGiftCard.add("Order Details");
        itemGiftCard.add("My Order");
        itemGiftCard.add("Write a Review");
        itemGiftCard.add("Report");

        itemMySetting = new ArrayList();
        itemMySetting.add("Account Information");
        itemMySetting.add("Secuirty Settings");
        itemMySetting.add("Identity");


        itemManageGroupFriends = new ArrayList();
        itemManageGroupFriends.add("My Groups");
        itemManageGroupFriends.add("Add New Groups");

        itemTrasactionHistory = new ArrayList();
        itemTrasactionHistory.add("Transaction History Screen");
        itemTrasactionHistory.add("Filter Transaction History");
        itemTrasactionHistory.add("Transaction Report");
        itemTrasactionHistory.add("Transaction Report");
        itemTrasactionHistory.add("Wallet History");
        itemTrasactionHistory.add("Wallet History");
        itemTrasactionHistory.add("Fund Transfer History");
        itemTrasactionHistory.add("Transaction Details");
        itemTrasactionHistory.add("Download Transaction History");

        itemLoyalityPoints = new ArrayList();
        itemLoyalityPoints.add("Loyality Points Screen");
        itemLoyalityPoints.add("Redeem Coupon Code");
        itemLoyalityPoints.add("Loyality Points History");

        itemAgents = new ArrayList();
        itemAgents.add("Agents Finder");
        itemAgents.add("Agents Filter");
        itemAgents.add("Withdrawal");
        itemAgents.add("Verification");
        itemAgents.add("Withdrawal History");
        itemAgents.add("Download Report");

        itemCreditFacility = new ArrayList();
        itemCreditFacility.add("Loan Repayment History");
        itemCreditFacility.add("Loan Running Balance");
        itemCreditFacility.add("Loan/Credit Issuance");

        itemOtherFeatures = new ArrayList();
        itemOtherFeatures.add("New Agent Registration");
        itemOtherFeatures.add("Registration Process");
        itemOtherFeatures.add("Mobile Saving Account");
        itemOtherFeatures.add("Cash-in &Cash-out");
        itemOtherFeatures.add("Mobile to ATM");
        itemOtherFeatures.add("Voucher Transfer");
        itemOtherFeatures.add("QR-Barcode");
        itemOtherFeatures.add("Cash Withdrawal/Deposit");
        itemOtherFeatures.add("Agent handling Capabilities");
        itemOtherFeatures.add("Reversal Capabilities");
        itemOtherFeatures.add("Interoperability Capabilites");
        itemOtherFeatures.add("Multicurrency");
        itemOtherFeatures.add("Real-time reporting");
        itemOtherFeatures.add("Statement Download");
        itemOtherFeatures.add("Customer Support");
        itemOtherFeatures.add("Bluetooth Report");
        itemOtherFeatures.add("Help &Chat");
        itemOtherFeatures.add("Term &Conditions");
        itemOtherFeatures.add("Privacy &Policy");
        itemOtherFeatures.add("Company &About Us.");
    }

    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_drawer, parent, false);
        HomeProfile homeProfile = new HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {
        if (position == 0) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemSubCategory);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);

        } else if (position == 1) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemSubMoneyTransfer);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 2) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemWallet);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 3) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemHotelBooking);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 4) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemEcom);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 5) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemGiftCard);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 6) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemMySetting);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 7) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemManageGroupFriends);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 8) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemTrasactionHistory);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 9) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemLoyalityPoints);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 10) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemAgents);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 11) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemCreditFacility);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        } else if (position == 12) {
            drawerItemAdapater = new DrawerItemAdapater(context, itemOtherFeatures);
            holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            holder.rvMenuItem.setAdapter(drawerItemAdapater);
        }

        holder.tvTitleName.setText(itemTitleName.get(position).toString());
        holder.tvTitleName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 4) {
                    EcomHomeFragment ecomHomeFragment = new EcomHomeFragment();
                    homeActivity.callFragment(ecomHomeFragment);
                } else if (position == 2) {
                    MyWallet ecomHomeFragment = new MyWallet();
                    homeActivity.callFragmentTopInvisible(ecomHomeFragment);
                } else if (position == 1) {
                    TransferFragment ecomHomeFragment = new TransferFragment();
                    homeActivity.callFragmentFullScreen(ecomHomeFragment);
                } else if (position == 3) {
                    AllServiceFragment allServiceFragment = new AllServiceFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                } else if (position == 0) {
                    PaybillsFragment allServiceFragment = new PaybillsFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                } else if (position == 5) {
                    DepositInToTheWalletFragment allServiceFragment = new DepositInToTheWalletFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                }else if (position == 6) {
                    AllServiceSettingFragment allServiceFragment = new AllServiceSettingFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);

                }else if (position == 7) {
                    //for withdraw flow
                    AllServiceReceiveMoneyFragment allServiceFragment = new AllServiceReceiveMoneyFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                }else if (position == 8) {
                    //for withdraw flow
                    WithdrawFragment allServiceFragment = new WithdrawFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                }else if (position == 9) {
                    //for withdraw flow
                    SearchFragment allServiceFragment = new SearchFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment);
                }

            }
        });


        holder.rvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagOpenClose.get(position).toString().equalsIgnoreCase("false")) {
                    holder.rvMenuItem.setVisibility(View.VISIBLE);
                    flagOpenClose.set(position, true);
                    holder.ivDown.setVisibility(View.VISIBLE);
                    //notifyDataSetChanged();

                } else {
                    holder.rvMenuItem.setVisibility(View.GONE);
                    flagOpenClose.set(position, false);
                    holder.ivDown.setVisibility(View.GONE);
                    //notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemTitleName.size();
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        RecyclerView rvMenuItem;
        RelativeLayout rvTitle;
        AppCompatTextView tvTitleName;
        AppCompatImageView ivDown;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvMenuItem = itemView.findViewById(R.id.rvMenuItem);
            rvTitle = itemView.findViewById(R.id.rvTitle);
            tvTitleName = itemView.findViewById(R.id.tvTitleName);
            ivDown = itemView.findViewById(R.id.ivDown);


        }
    }


}
