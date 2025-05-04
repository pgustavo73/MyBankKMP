//
//  HostingStatusBarController.swift
//  iosApp
//
//  Created by Paulo Gustavo on 02/05/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import UIKit

class HostingStatusBarController: UIViewController {
    private let rootViewController: UIViewController

    init(rootViewController: UIViewController) {
        self.rootViewController = rootViewController
        super.init(nibName: nil, bundle: nil)
        addChild(rootViewController)
        view.addSubview(rootViewController.view)
        rootViewController.view.frame = view.bounds
        rootViewController.view.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        rootViewController.didMove(toParent: self)
    }

    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }

    override var childForStatusBarStyle: UIViewController? {
        return nil 
    }
}

